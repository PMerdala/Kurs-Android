package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.navigation.SplashRouter
import pl.pmerdala.kursandroid.feature.splash.presentation.SplashPresenter
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity
import pl.pmerdala.kursandroid.feature.tools.parcel.ParcelableProvider
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration

@Module
class SplashModule {

    @Provides
    fun router(
        activity: SplashActivity,
        parcelableProvider: ParcelableProvider,
        configuration: Configuration
    ): SplashContract.Router = SplashRouter(activity, parcelableProvider,configuration)


    @Provides
    fun presenter(
        router: SplashContract.Router,
        configuration: Configuration,
        compositeDisposable: CompositeDisposable
    ): SplashContract.Presenter = SplashPresenter(router, configuration, compositeDisposable)
}
