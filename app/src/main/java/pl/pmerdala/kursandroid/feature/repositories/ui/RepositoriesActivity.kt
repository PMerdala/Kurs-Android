package pl.pmerdala.kursandroid.feature.repositories.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import org.parceler.Parcels
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.commons.ui.BaseActivity
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
import pl.pmerdala.kursandroid.feature.utils.configuration.StringConstants
import timber.log.Timber
import javax.inject.Inject

class RepositoriesActivity : BaseActivity(),RepositoriesContract.View
{
    @Inject
    lateinit var presenter: RepositoriesContract.Presenter

    override val layoutId: Int
            = R.layout.activity_repositories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
        val extra  :Parcelable? = intent.getParcelableExtra(StringConstants.EXTRA_KEY_EXAMPLE)
        extra?.let {
            val value = Parcels.unwrap<Int>(it)
            Timber.d("Extra value passed to activity is $value")
        }
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }
}
