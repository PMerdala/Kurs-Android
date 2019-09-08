package pl.pmerdala.kursandroid.feature.repositories.presentation

import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import org.junit.After
import org.junit.Before
import org.junit.Test

import pl.pmerdala.kursandroid.feature.splash.BaseTest

import org.junit.Assert.*
import org.mockito.Mock
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract

class RepositoriesPresenterTest : BaseTest() {


    @Mock
    private lateinit var view: RepositoriesContract.View

    @Mock
    private lateinit var router: RepositoriesContract.Router

    private lateinit var presenter: RepositoriesContract.Presenter


    override fun setup() {
        super.setup()
        presenter = RepositoriesPresenter(view,router)
    }

    @After
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