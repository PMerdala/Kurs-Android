package pl.pmerdala.kursandroid.feature.splash

import pl.pmerdala.kursandroid.feature.commons.BaseContract

class SplashContract {
    interface Router {
        fun navigateToLogin()
        fun navigateToRepositories()
    }

    interface Presenter : BaseContract.Presenter {
        fun visible()
    }
}