package pl.pmerdala.kursandroid.feature.splash.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import butterknife.BindView
import butterknife.OnClick
import dagger.android.AndroidInjection
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.commons.ui.BaseActivity
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.navigation.SplashRouter
import pl.pmerdala.kursandroid.feature.splash.presentation.SplashPresenter
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @BindView(R.id.splash_image)
    lateinit var splashImage: ImageView

    @Inject
    lateinit var presenter: SplashContract.Presenter

    override val layoutId: Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
    }

    override fun onResume() {
        super.onResume()
        presenter.visible()
    }

    override fun onPause() {
        super.onPause()
        presenter.hide()
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }

    @OnClick(R.id.splash_image)
    fun splashImageClicked() {
        splashImage.animate().rotation(180.0f).start()
    }

    fun startActivity(activityClass:Class<*>){
        val intent = Intent(this,activityClass)
        startActivity(intent)
    }
}