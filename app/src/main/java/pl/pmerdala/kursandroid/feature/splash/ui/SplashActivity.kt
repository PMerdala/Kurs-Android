package pl.pmerdala.kursandroid.feature.splash.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.navigation.SplashRouter
import pl.pmerdala.kursandroid.feature.splash.presentation.SplashPresenter

class SplashActivity:AppCompatActivity(),SplashContract.View {

    private lateinit var presenter:SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        presenter = SplashPresenter(this,SplashRouter())
        presenter.initialize()
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }
}