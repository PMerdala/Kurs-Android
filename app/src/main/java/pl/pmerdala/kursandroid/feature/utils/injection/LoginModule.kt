package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.pmerdala.kursandroid.feature.login.LoginContract
import pl.pmerdala.kursandroid.feature.login.navigation.LoginRouter
import pl.pmerdala.kursandroid.feature.login.presentation.LoginPresenter
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity
import pl.pmerdala.kursandroid.feature.tools.permissions.PermissionsHelper
import pl.pmerdala.kursandroid.feature.tools.permissions.PermissionsHelperImpl
import pl.pmerdala.kursandroid.feature.utils.api.UsersService
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import retrofit2.Retrofit

@Module
class LoginModule {

    @Provides
    fun usersService(retrofit: Retrofit): UsersService = retrofit.create(UsersService::class.java)

    @Provides
    fun router(
        activity: LoginActivity
    ): LoginContract.Router = LoginRouter(activity)

    @Provides
    fun permissionsHelper(activity: LoginActivity): PermissionsHelper =
        PermissionsHelperImpl(activity)

    @Provides
    fun presenter(
        activity: LoginActivity,
        router: LoginContract.Router,
        permissionsHelper: PermissionsHelper,
        usersService: UsersService,
        compositeDisposable: CompositeDisposable,
        configuration: Configuration
    ): LoginContract.Presenter =
        LoginPresenter(
            activity,
            router,
            permissionsHelper,
            usersService,
            compositeDisposable,
            configuration
        )
}