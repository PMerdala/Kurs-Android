package pl.pmerdala.kursandroid.feature.splash.presentation

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SplashPresenter(
    private val router: SplashContract.Router,
    private val configuration: Configuration,
    private val compositeDisposable: CompositeDisposable
) :
    SplashContract.Presenter {

    companion object {
        const val TIMEOUT = 3500L
    }

    override fun initialize() = Unit

    override fun clear() = Unit

    override fun visible() {
        compositeDisposable.add(Observable.just(Unit)
            .delay(TIMEOUT, TimeUnit.MILLISECONDS)
            .subscribe(
                { navigation() },
                { Timber.e(it) }
            )
        )

    }

    override fun hide() {
        compositeDisposable.clear()
    }


    private fun navigation() {
        if (configuration.isUserLoggedIn()) {
            router.navigateToRepositories()
        } else {
            router.navigateToLogin()
        }
    }
}