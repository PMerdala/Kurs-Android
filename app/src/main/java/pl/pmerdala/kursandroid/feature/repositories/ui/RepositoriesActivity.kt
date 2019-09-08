package pl.pmerdala.kursandroid.feature.repositories.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.commons.ui.BaseActivity
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
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
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }
}
