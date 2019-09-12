package pl.pmerdala.kursandroid.feature.utils.configuration

import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ConfigurationImplTest {

    lateinit var configuration:Configuration

    @Before
    fun setUp() {
        configuration = ConfigurationImpl()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `shouldReturnFalseAsDefaultValueWhenIsUserLoggedInCallWithoutLogin`() {
        val value:Boolean = configuration.isUserLoggedIn()
        assertFalse("spodziewano się wartości false", value)
    }

    @Test
    fun `shouldReturnTrueAsDefaultValueWhenIsUserLoggedInCallAfterLogin`() {
        val username = "username"
        configuration.usertLogin= username
        val value:Boolean = configuration.isUserLoggedIn()
        assertTrue("spodziewano się wartości true", value)
        assertEquals(username,configuration.usertLogin)
    }

}