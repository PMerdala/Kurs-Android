package pl.pmerdala.kursandroid.feature.splash.presentation

import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import timber.log.Timber

class SplashPresenter(
    val router: SplashContract.Router,
    val configuration: Configuration
) :
    SplashContract.Presenter {

    override fun initialize() = Unit

    override fun clear() = Unit

    override fun visible() {
        if (configuration.isUserLoggedIn()) {
            router.navigateToRepositories()
        } else {
            router.navigateToLogin()
        }
    }
}