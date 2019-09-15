package pl.pmerdala.kursandroid.feature.repositories.presentation

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Test
import org.mockito.ArgumentMatcher
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import pl.pmerdala.kursandroid.data.RepositoryData
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
import pl.pmerdala.kursandroid.feature.splash.BaseTest
import pl.pmerdala.kursandroid.feature.utils.api.RepositoriesService
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration

class RepositoriesPresenterTest : BaseTest() {


    @Mock
    private lateinit var view: RepositoriesContract.View

    @Mock
    private lateinit var router: RepositoriesContract.Router

    @Mock
    private lateinit var repositoriesService: RepositoriesService

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var configuration: Configuration

    private lateinit var presenter: RepositoriesContract.Presenter


    override fun setup() {
        super.setup()
        presenter = RepositoriesPresenter(view,router,repositoriesService,configuration, compositeDisposable)
        trampolineRxPlugin()
    }

    @After
    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(view,router,repositoriesService,configuration,compositeDisposable)
    }

    @Test
    fun `should do nothing when initialize is called`() {
        val username = "Username"
        val repositoryData:RepositoryData = RepositoryData("Title Test","Subtitle test","url")
        `when`(configuration.usertLogin).thenReturn(username)
        `when`(repositoriesService.repositories(username)).thenReturn(Observable.just(repositoryData))
        presenter.initialize()
        verify(repositoriesService,times(1)).repositories(username)
        verify(configuration, times(1)).usertLogin
        verify(compositeDisposable,times(1)).add(ArgumentMatchers.any())
    }

    @Test
    fun `should do nothing when clear is called`() {
        presenter.clear()
        verify(compositeDisposable, times(1)).clear()
    }
}