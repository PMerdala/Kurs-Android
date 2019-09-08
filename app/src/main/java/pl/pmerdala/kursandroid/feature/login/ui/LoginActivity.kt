package pl.pmerdala.kursandroid.feature.login.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.commons.ui.BaseActivity
import pl.pmerdala.kursandroid.feature.login.LoginContract
import javax.inject.Inject

class LoginActivity : BaseActivity(),LoginContract.View {

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
}
