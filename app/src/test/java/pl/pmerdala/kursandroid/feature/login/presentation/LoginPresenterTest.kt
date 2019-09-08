package pl.pmerdala.kursandroid.feature.login.presentation

import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import org.junit.After
import org.junit.Before
import org.junit.Test

import pl.pmerdala.kursandroid.feature.splash.BaseTest

import org.junit.Assert.*
import org.mockito.Mock
import pl.pmerdala.kursandroid.feature.login.LoginContract

class LoginPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: LoginContract.View

    @Mock
    private lateinit var router:LoginContract.Router

    private lateinit var presenter: LoginContract.Presenter


    override  fun setup() {
        super.setup()
        presenter = LoginPresenter(view,router)
    }


    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(view,router)
    }

    @Test
    fun `should do nothing when initialize is called`() {
        presenter.initialize()
    }

    @Test
    fun `should do nothing when clear is called`() {
        presenter.clear()
    }
}