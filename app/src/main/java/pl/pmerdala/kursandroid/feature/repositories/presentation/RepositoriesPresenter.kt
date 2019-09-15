package pl.pmerdala.kursandroid.feature.repositories.presentation

import com.orhanobut.hawk.Hawk
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.pmerdala.kursandroid.feature.login.presentation.LoginPresenter
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
import pl.pmerdala.kursandroid.feature.utils.api.RepositoriesService
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import timber.log.Timber

class RepositoriesPresenter(
    private val view: RepositoriesContract.View,
    private val router: RepositoriesContract.Router,
    private val repositoriesService: RepositoriesService,
    private val configuration:Configuration,
    private val compositeDisposable: CompositeDisposable
) : RepositoriesContract.Presenter {
    override fun initialize() {
        compositeDisposable.add(
            repositoriesService
                .repositories(configuration.usertLogin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .distinct()
                .subscribe {
                    view.setList(it)
                }
        )
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}