package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.pmerdala.kursandroid.feature.login.LoginContract
import pl.pmerdala.kursandroid.feature.login.navigation.LoginRouter
import pl.pmerdala.kursandroid.feature.login.presentation.LoginPresenter

@Module
class LoginModule {
    @Provides
    fun router():LoginContract.Router = LoginRouter()

    @Provides
    fun presenter():LoginContract.Presenter = LoginPresenter()
}