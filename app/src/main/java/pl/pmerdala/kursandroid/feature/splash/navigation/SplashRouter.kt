package pl.pmerdala.kursandroid.feature.splash.navigation

import android.content.Intent
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity

class SplashRouter(
    private val activity: SplashActivity
) : SplashContract.Router {
    override fun navigateToRepositories() {
        activity.startActivity(
            RepositoriesActivity::class.java,
            listOf(
                Intent.FLAG_ACTIVITY_NEW_TASK,
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
        )
    }

    override fun navigateToLogin() {
        activity.startActivity(
            LoginActivity::class.java,
            listOf(
                Intent.FLAG_ACTIVITY_NEW_TASK,
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
        )
    }
}