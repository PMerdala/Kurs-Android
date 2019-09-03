package pl.pmerdala.kursandroid.feature.splash.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.navigation.SplashRouter
import pl.pmerdala.kursandroid.feature.splash.presentation.SplashPresenter
import timber.log.Timber

class SplashActivity:AppCompatActivity(),SplashContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Timber.d("SplashAvtivity onCreate done")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}