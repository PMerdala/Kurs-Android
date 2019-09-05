package pl.pmerdala.kursandroid.feature.splash.presentation

import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import pl.pmerdala.kursandroid.feature.splash.BaseTest
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration

class SplashPresenterTest : BaseTest() {

    @Mock
    private lateinit var router: SplashContract.Router

    @Mock
    private lateinit var configuration: Configuration


    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var presenter: SplashContract.Presenter

    override fun setup() {
        super.setup()
        trampolineRxPlugin()
        presenter = SplashPresenter(router, configuration, compositeDisposable)
    }

    override fun tearDown() {
        super.tearDown()
        Mockito.verifyNoMoreInteractions(router, configuration, compositeDisposable)
    }

    @Test
    fun `Should do nothing when initialize is called`() {
        presenter.initialize()
    }

    @Test
    fun `Should do nothing when clear is called`() {
        presenter.clear()
    }

    @Test
    fun `should navigate to login when user is not logged in`() {
        `when`(configuration.isUserLoggedIn()).thenReturn(false)

        presenter.visible()

        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(configuration, times(1)).isUserLoggedIn()
        verify(router, times(1)).navigateToLogin()
    }

    @Test
    fun `should navigate to login when user is logged in`() {
        `when`(configuration.isUserLoggedIn()).thenReturn(true)

        presenter.visible()

        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(configuration, times(1)).isUserLoggedIn()
        verify(router, times(1)).navigateToRepositories()
    }

    @Test
    fun `should stop disposable when user hide application`() {
        presenter.hide()
        verify(compositeDisposable, times(1)).clear()
    }

}