package pl.pmerdala.kursandroid.feature.splash.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.splash.SplashContract
import pl.pmerdala.kursandroid.feature.splash.navigation.SplashRouter
import pl.pmerdala.kursandroid.feature.splash.presentation.SplashPresenter
import timber.log.Timber

class SplashActivity : AppCompatActivity(), SplashContract.View {

    @BindView(R.id.splash_image)
    lateinit var splashImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ButterKnife.bind(this)
        Timber.d("SplashAvtivity onCreate done")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    @OnClick(R.id.splash_image)
    fun splashImageClicked() {
        splashImage.animate().rotation(180.0f).start()
    }
}