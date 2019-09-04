package pl.pmerdala.kursandroid.feature.splash.presentation

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import pl.pmerdala.kursandroid.feature.splash.SplashContract

class SplashPresenterTest {

    @Mock
    private lateinit var view: SplashContract.View

    @Mock
    private lateinit var router: SplashContract.Router

    private lateinit var presenter: SplashContract.Presenter

    @Before
    fun setup() {
        presenter = SplashPresenter(view, router)
    }

    @Test
    fun initialize() {
    }

    @Test
    fun clear() {
    }
}