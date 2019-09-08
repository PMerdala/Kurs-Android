package pl.pmerdala.kursandroid.feature.splash.navigation


import android.content.Intent
import android.os.Parcelable
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.parceler.Parcels
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.pmerdala.kursandroid.feature.splash.BaseTest
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity
import pl.pmerdala.kursandroid.feature.tools.parcel.ParcelableProvider
import pl.pmerdala.kursandroid.feature.utils.configuration.StringConstants
import org.mockito.Mockito.`when`
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration

class SplashRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: SplashActivity

    @Mock
    private lateinit var parcelableProvider: ParcelableProvider

    @Mock
    private lateinit var parcelable: Parcelable

    @Mock
    private lateinit var configuration: Configuration

    private lateinit var router: SplashContract.Router

    override fun setup() {
        super.setup()
        router = SplashRouter(
            activity,
            parcelableProvider,
            configuration
            )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
            activity,
            parcelableProvider,
            configuration
        )
    }

    @Test
    fun `should navigate to login activity when navigateToLogin is called`() {
        router.navigateToLogin()
        verify(activity, times(1)).startActivity(
            LoginActivity::class.java,
            listOf(
                Intent.FLAG_ACTIVITY_NEW_TASK,
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            )
        )
    }

    @Test
    fun `should navigate to respositories activity when navigateToRepositories is called`() {
        val from = 12
        `when`(configuration.exampleExtra).thenReturn(from)
        `when`(parcelableProvider.from(from)).thenReturn(parcelable)
        router.navigateToRepositories()
        verify(parcelableProvider,times(1)).from(from)
        verify(configuration,times(1)).exampleExtra
        verify(activity, times(1)).startActivity(
            RepositoriesActivity::class.java,
            listOf(
                Intent.FLAG_ACTIVITY_NEW_TASK,
                Intent.FLAG_ACTIVITY_CLEAR_TASK
            ),
            Pair(StringConstants.EXTRA_KEY_EXAMPLE, parcelable)
        )
    }


}