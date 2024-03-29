package pl.pmerdala.kursandroid.feature.utils.injection

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity

@Module
abstract class ActivityBinderModule {

    @Binds
    abstract fun activity(activity: AppCompatActivity): AppCompatActivity

    @ContributesAndroidInjector(
        modules =
        [SplashModule::class]
    )
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(
        modules =
        [LoginModule::class]
    )
    abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(
        modules =
        [RepositoriesModule::class]
    )
    abstract fun bindRepositoriesActivity(): RepositoriesActivity
}