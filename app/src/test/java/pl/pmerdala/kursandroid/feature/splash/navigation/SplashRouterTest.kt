package pl.pmerdala.kursandroid.feature.splash.navigation


import android.content.Intent
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.pmerdala.kursandroid.feature.splash.BaseTest
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.ui.SplashActivity

class SplashRouterTest : BaseTest(){

    @Mock
    private lateinit var activity: SplashActivity

    private lateinit var router:SplashContract.Router

    override fun setup() {
        super.setup()
        router = SplashRouter(activity)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(activity)
    }

    @Test
    fun `should navigate to login activity when navigateToLogin is called`(){
        router.navigateToLogin()
        verify(activity, times(1)).startActivity(LoginActivity::class.java,
            listOf(Intent.FLAG_ACTIVITY_NEW_TASK,Intent.FLAG_ACTIVITY_CLEAR_TASK))
    }

    @Test
    fun `should navigate to respositories activity when navigateToRepositories is called`(){
        router.navigateToRepositories()
        verify(activity, times(1)).startActivity(RepositoriesActivity::class.java,
            listOf(Intent.FLAG_ACTIVITY_NEW_TASK,Intent.FLAG_ACTIVITY_CLEAR_TASK))
    }


}