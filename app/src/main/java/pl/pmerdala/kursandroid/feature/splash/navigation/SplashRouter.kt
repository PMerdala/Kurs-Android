package pl.pmerdala.kursandroid.feature.splash.navigation

import android.content.Intent
import org.parceler.Parcels
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity
import pl.pmerdala.kursandroid.feature.tools.parcel.ParcelableProvider
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import pl.pmerdala.kursandroid.feature.utils.configuration.StringConstants

class SplashRouter(
    private val activity: SplashActivity,
    private val parcelableProvider: ParcelableProvider,
    private val configuration: Configuration
) : SplashContract.Router {
    override fun navigateToRepositories() {
        activity.startActivity(
            RepositoriesActivity::class.java,
            listOf(
                Intent.FLAG_ACTIVITY_NEW_TASK,
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            ),
            Pair(
                StringConstants.EXTRA_KEY_EXAMPLE,
                parcelableProvider.from(
                    configuration.exampleExtra
                )
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