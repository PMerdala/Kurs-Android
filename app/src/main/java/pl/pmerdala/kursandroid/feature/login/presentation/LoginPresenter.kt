package pl.pmerdala.kursandroid.feature.login.presentation

import pl.pmerdala.kursandroid.feature.login.LoginContract

class LoginPresenter(
    view: LoginContract.View,
    router: LoginContract.Router
) : LoginContract.Presenter {
    override fun initialize() = Unit

    override fun clear() = Unit
}