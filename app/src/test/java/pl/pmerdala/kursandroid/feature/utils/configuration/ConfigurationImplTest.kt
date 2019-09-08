package pl.pmerdala.kursandroid.feature.utils.configuration

import android.content.SharedPreferences
import com.nhaarman.mockito_kotlin.anyOrNull
import com.orhanobut.hawk.Hawk
import com.orhanobut.hawk.Storage
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.internal.verification.NoMoreInteractions
import org.mockito.internal.verification.VerificationModeFactory
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import pl.pmerdala.kursandroid.KursApplication

@RunWith(PowerMockRunner::class)
@PrepareForTest(Hawk::class)
class ConfigurationImplTest {

    @Mock
    private lateinit var kursApplication: KursApplication
    private lateinit var configuration:Configuration
    private lateinit var storage: Storage
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var preferences: SharedPreferences

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        initHawkInvockObject()
        PowerMockito.mockStatic(Hawk::class.java)
        PowerMockito.spy(kursApplication)
        PowerMockito.`when`(kursApplication.getSharedPreferences(anyString(), anyInt())).thenReturn(preferences)
        PowerMockito.`when`(kursApplication.getApplicationContext()).thenReturn(kursApplication)
        Hawk.init(kursApplication).build()
        configuration = ConfigurationImpl()
    }

    @After
    fun tearDown() {
        PowerMockito.verifyStatic(Hawk::class.java, NoMoreInteractions())
    }

    @Test
    fun `should return true when Hawk has true value`() {
        `when`(Hawk.get<Boolean>(ConfigurationImpl.PREFS_KEY_LOGGED_IN, anyOrNull())).thenReturn(true)
        PowerMockito.verifyStatic(Hawk::class.java, Mockito.times(1))
        val userisLoogedIn : Boolean = configuration.isUserLoggedIn()
        assertTrue("expect isUserLoggedIn return true",userisLoogedIn)
    }
    @Test
    fun `should return false when Hawk has false value`() {
        `when`(Hawk.get<Boolean>(ConfigurationImpl.PREFS_KEY_LOGGED_IN, anyOrNull())).thenReturn(false)
        PowerMockito.verifyStatic(Hawk::class.java,Mockito.times(1))
        val userisLoogedIn : Boolean = configuration.isUserLoggedIn()
        assertFalse("expect isUserLoggedIn return false",userisLoogedIn)
    }

    private fun initHawkInvockObject(){
        editor = Mockito.spy<SharedPreferences.Editor>(object : SharedPreferences.Editor {
            override fun putString(key: String, value: String?): SharedPreferences.Editor {
                return this
            }

            override fun putStringSet(key: String, values: Set<String>?): SharedPreferences.Editor {
                return this
            }

            override fun putInt(key: String, value: Int): SharedPreferences.Editor {
                return this
            }

            override fun putLong(key: String, value: Long): SharedPreferences.Editor {
                return this
            }

            override fun putFloat(key: String, value: Float): SharedPreferences.Editor {
                return this
            }

            override fun putBoolean(key: String, value: Boolean): SharedPreferences.Editor {
                return this
            }

            override fun remove(key: String): SharedPreferences.Editor {
                return this
            }

            override fun clear(): SharedPreferences.Editor {
                return this
            }

            override fun commit(): Boolean {
                return true
            }

            override fun apply() {}
        })
        preferences = Mockito.spy<SharedPreferences>(object : SharedPreferences {
            override fun getAll(): Map<String, *> {
                val map = HashMap<String, Any>()
                map["key"] = "value"
                return map
            }

            override fun getString(key: String, defValue: String?): String? {
                return null
            }

            override fun getStringSet(key: String, defValues: Set<String>?): Set<String>? {
                return null
            }

            override fun getInt(key: String, defValue: Int): Int {
                return 0
            }

            override fun getLong(key: String, defValue: Long): Long {
                return 0
            }

            override fun getFloat(key: String, defValue: Float): Float {
                return 0f
            }

            override fun getBoolean(key: String, defValue: Boolean): Boolean {
                return false
            }

            override fun contains(key: String): Boolean {
                return false
            }

            override fun edit(): SharedPreferences.Editor? {
                return editor
            }

            override fun registerOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {

            }

            override fun unregisterOnSharedPreferenceChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {

            }
        })
        storage = Mockito.spy<Storage>(object : Storage {
            override fun contains(key: String?): Boolean = false

            override fun count(): Long = 0

            override fun <T : Any?> put(key: String?, value: T): Boolean = true

            override fun <T : Any?> get(key: String?): T? {
                return null
            }

            override fun deleteAll(): Boolean = true

            override fun delete(key: String?): Boolean = true
        })

    }

}