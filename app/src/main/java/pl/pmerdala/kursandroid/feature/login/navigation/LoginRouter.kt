package pl.pmerdala.kursandroid.feature.login.navigation

import android.content.Intent
import pl.pmerdala.kursandroid.feature.login.LoginContract
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesActivity

class LoginRouter(
    private val activity: LoginActivity
) :LoginContract.Router {

    override fun finish() {
        activity.finish()
    }
    override fun navigateToRepositories() {
        activity.startActivity(
            RepositoriesActivity::class.java,
            listOf(
                Intent.FLAG_ACTIVITY_NEW_TASK,
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
        )
    }
}