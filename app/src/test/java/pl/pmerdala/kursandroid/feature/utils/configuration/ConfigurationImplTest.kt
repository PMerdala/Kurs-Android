package pl.pmerdala.kursandroid.feature.utils.configuration

import com.orhanobut.hawk.Hawk
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.mockito.internal.verification.NoMoreInteractions
import org.mockito.internal.verification.VerificationModeFactory
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(Hawk::class)
class ConfigurationImplTest {

    private lateinit var configuration:Configuration


    @Before
    fun setUp() {
        PowerMockito.mockStatic(Hawk::class.java)
        configuration = ConfigurationImpl()
    }

    @After
    fun tearDown() {
        PowerMockito.verifyStatic(Hawk::class.java, NoMoreInteractions())
    }

    @Test
    fun `should return true when Hawk has true value`() {
        Mockito.`when`(Hawk.get<Boolean>(ConfigurationImpl.PREFS_KEY_LOGGED_IN,false)).thenReturn(true)
        val userisLoogedIn : Boolean = configuration.isUserLoggedIn()
        assertTrue("expect isUserLoggedIn return true",userisLoogedIn)
        PowerMockito.verifyStatic(Hawk::class.java, Mockito.times(1))
    }
    @Test
    fun `should return false when Hawk has false value`() {
        Mockito.`when`(Hawk.get<Boolean>(ConfigurationImpl.PREFS_KEY_LOGGED_IN,false)).thenReturn(false)
        val userisLoogedIn : Boolean = configuration.isUserLoggedIn()
        assertFalse("expect isUserLoggedIn return false",userisLoogedIn)
        PowerMockito.verifyStatic(Hawk::class.java,Mockito.times(1))
    }
}