package pl.pmerdala.kursandroid.feature.splash.ui

import android.os.Bundle
import android.widget.ImageView
import butterknife.BindView
import butterknife.OnClick
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.commons.ui.BaseActivity
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.navigation.SplashRouter
import pl.pmerdala.kursandroid.feature.splash.presentation.SplashPresenter

class SplashActivity : BaseActivity(), SplashContract.View {

    @BindView(R.id.splash_image)
    lateinit var splashImage: ImageView

    private lateinit var presenter: SplashContract.Presenter

    override val layoutId: Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SplashPresenter(this,SplashRouter())
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    @OnClick(R.id.splash_image)
    fun splashImageClicked() {
        splashImage.animate().rotation(180.0f).start()
    }
}