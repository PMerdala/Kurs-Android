package pl.pmerdala.kursandroid.feature.login.navigation

import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import org.junit.After
import org.junit.Before

import pl.pmerdala.kursandroid.feature.splash.BaseTest

import org.junit.Assert.*
import org.mockito.Mock
import pl.pmerdala.kursandroid.feature.login.LoginContract

class LoginRouterTest : BaseTest() {

    @Mock
    private lateinit var view: LoginContract.View

    private lateinit var router : LoginContract.Router


    override fun setup() {
        super.setup()
        router = LoginRouter(view)
    }

    @After
    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(view)
    }
}