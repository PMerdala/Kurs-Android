package pl.pmerdala.kursandroid.feature.login.navigation

import pl.pmerdala.kursandroid.feature.login.LoginContract
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity

class LoginRouter(
    private val activity: LoginActivity
) :LoginContract.Router {
    override fun finish() {
        activity.finish()
    }
}