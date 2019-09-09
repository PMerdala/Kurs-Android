package pl.pmerdala.kursandroid.feature.login.navigation

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import org.junit.After
import org.junit.Before

import pl.pmerdala.kursandroid.feature.splash.BaseTest

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mock
import pl.pmerdala.kursandroid.feature.login.LoginContract
import pl.pmerdala.kursandroid.feature.login.ui.LoginActivity

class LoginRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: LoginActivity

    private lateinit var router : LoginContract.Router


    override fun setup() {
        super.setup()
        router = LoginRouter(activity)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(activity)
    }

    @Test
    fun `should finish activity when finish is called`(){
        router.finish()
        verify(activity, times(1)).finish()
    }
}