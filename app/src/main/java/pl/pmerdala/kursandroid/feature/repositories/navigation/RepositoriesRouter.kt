package pl.pmerdala.kursandroid.feature.repositories.navigation

import android.content.Intent
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity

class RepositoriesRouter(val activity: RepositoriesActivity) : RepositoriesContract.Router {
    override fun navigateToLogin() {
        activity.startActivity(
            SplashActivity::class.java,
            listOf(
                Intent.FLAG_ACTIVITY_NEW_TASK,
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
        )
    }
}