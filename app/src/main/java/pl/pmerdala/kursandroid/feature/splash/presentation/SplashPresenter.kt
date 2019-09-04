package pl.pmerdala.kursandroid.feature.splash.presentation

import pl.pmerdala.kursandroid.feature.splash.SplashContract
import timber.log.Timber

class SplashPresenter(val view: SplashContract.View, val router: SplashContract.Router) :
    SplashContract.Presenter {

    override fun initialize() {
        Timber.d("Presenter is initialized!")
    }

    override fun clear() {
        Timber.d("Presenter is cleared")
    }
}