package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.navigation.SplashRouter
import pl.pmerdala.kursandroid.feature.splash.presentation.SplashPresenter
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration

@Module
class SplashModule {

    @Provides
    fun router(): SplashContract.Router = SplashRouter()


    @Provides
    fun presenter(
        router: SplashContract.Router,
        configuration:Configuration
    ): SplashContract.Presenter = SplashPresenter(router,configuration)
}
