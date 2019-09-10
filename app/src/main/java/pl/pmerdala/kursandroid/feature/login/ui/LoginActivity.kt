package pl.pmerdala.kursandroid.feature.login.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.commons.ui.BaseActivity
import pl.pmerdala.kursandroid.feature.login.LoginContract
import javax.inject.Inject

class LoginActivity : BaseActivity(),LoginContract.View {

    @BindView(R.id.login_button)
    lateinit var loginButton : Button

    @BindView(R.id.login_edit_text)
    lateinit var loginEditTest:EditText

    @Inject
    lateinit var presenter:LoginContract.Presenter

    override val layoutId: Int
            = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }
    override fun showMessage(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun getLoginClickObservable(): Observable<Unit> =
        RxView.clicks(loginButton)
            .map{Unit}
            .subscribeOn(AndroidSchedulers.mainThread())

    override fun getUsername():String =
        loginEditTest.text.toString()
}
