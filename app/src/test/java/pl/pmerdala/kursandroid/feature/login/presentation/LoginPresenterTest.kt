package pl.pmerdala.kursandroid.feature.login.presentation

import android.Manifest
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import pl.pmerdala.kursandroid.feature.login.LoginContract
import pl.pmerdala.kursandroid.feature.splash.BaseTest
import pl.pmerdala.kursandroid.feature.tools.permissions.PermissionsHelper

class LoginPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: LoginContract.View

    @Mock
    private lateinit var router: LoginContract.Router

    @Mock
    private lateinit var permissionsHelper: PermissionsHelper

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var presenter: LoginContract.Presenter


    override fun setup() {
        super.setup()
        trampolineRxPlugin()
        presenter = LoginPresenter(
            view,
            router,
            permissionsHelper,
            compositeDisposable
        )
    }


    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
            view,
            router,
            permissionsHelper,
            compositeDisposable
        )
    }

    @Test
    fun `should subscribe for permissions changes when initialize is called`() {
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn((Observable.never()))
        initialize()
    }

    private fun initialize() {
        presenter.initialize()
        verify(permissionsHelper, times(1)).request(Manifest.permission.CAMERA)
        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
    }

    @Test
    fun `should finish when permissions are not granted`(){
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn((Observable.just(false)))
        initialize()
        verify(router,times(1)).finish()
        verify(view,times(1)).showMessage(LoginPresenter.NO_PERMISSIONS_MESSAGE)
    }

    @Test
    fun `should do nothing when permissions are granted`(){
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn((Observable.just(true)))
        initialize()
    }

    @Test
    fun `should clear composite disposable when clear is called`() {
        presenter.clear()
        verify(compositeDisposable, times(1)).clear()
    }
}