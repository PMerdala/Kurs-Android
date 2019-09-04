package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.navigation.SplashRouter
import pl.pmerdala.kursandroid.feature.splash.presentation.SplashPresenter
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity

@Module
class SplashModule {

    @Provides
    fun router(): SplashContract.Router = SplashRouter()

    @Provides
    fun presenter(
        activity: SplashActivity,
        router: SplashContract.Router
    ): SplashContract.Presenter = SplashPresenter(activity, router)
}
