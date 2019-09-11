package pl.pmerdala.kursandroid.feature.login.presentation

import android.Manifest
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import pl.pmerdala.kursandroid.feature.login.LoginContract
import pl.pmerdala.kursandroid.feature.tools.permissions.PermissionsHelper
import pl.pmerdala.kursandroid.feature.utils.api.UsersService
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import timber.log.Timber

class LoginPresenter(
    private val view: LoginContract.View,
    private val router: LoginContract.Router,
    private val permissionsHelper: PermissionsHelper,
    private val usersService: UsersService,
    private val compositeDisposable: CompositeDisposable,
    private val configuration: Configuration
) : LoginContract.Presenter {

    companion object {
        const val NO_PERMISSIONS_MESSAGE = "You have to accept permissions to continue"
    }

    override fun initialize() {
        compositeDisposable.add(
            getCombinedObservable()
                .map { view.getUsername() }
                .filter { it.isNotEmpty() }
                .flatMap {
                    usersService.user(it)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                }
                .distinct()
                .subscribe(
                    {
                        val login = it.username
                        Timber.d("Request is successfull with user login: $login")
                        configuration.usertLogin = login
                        router.navigateToRepositories()
                    },
                    { Timber.e(it) }
                )
        )
    }

    private fun getCombinedObservable(): Observable<Unit> =
        Observable.combineLatest(
            getPermissionsGrantedObservable(),
            view.getLoginClickObservable(),
            BiFunction
            { _, _ -> Unit }
        )

    private fun getPermissionsGrantedObservable(): Observable<Unit> {
        return permissionsHelper
            .request(Manifest.permission.CAMERA)
            .doOnNext {
                if (!it) {
                    router.finish()
                    view.showMessage(NO_PERMISSIONS_MESSAGE)
                }
            }
            .filter { it }
            .map { Unit }
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}