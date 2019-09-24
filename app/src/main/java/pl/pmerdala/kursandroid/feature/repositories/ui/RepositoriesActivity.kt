package pl.pmerdala.kursandroid.feature.repositories.ui

import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.OnClick
import org.parceler.Parcels
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.feature.commons.ui.BaseActivity
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
import pl.pmerdala.kursandroid.feature.utils.configuration.StringConstants
import timber.log.Timber
import javax.inject.Inject
import pl.pmerdala.kursandroid.data.RepositoryData

class RepositoriesActivity : BaseActivity(), RepositoriesContract.View {

    @Inject
    lateinit var presenter: RepositoriesContract.Presenter

    @Inject
    lateinit var repositoriesAdapter: RepositoriesAdapter

    @Inject
    lateinit var layoutManager: RecyclerView.LayoutManager

    @BindView(R.id.repositories_list)
    lateinit var repositoriesList: RecyclerView

    override val layoutId: Int = R.layout.activity_repositories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeRecyclerView()
        presenter.initialize()
        initializeFromIntent()
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }

    override fun updateRepos(repositoryDatas: List<RepositoryData>) {
        repositoriesAdapter.updateData(repositoryDatas)
    }

    @OnClick(R.id.repositories_fab_logout)
    fun logoutClicked(){
        presenter.logoutClicked()
    }

    private fun initializeRecyclerView() {
        repositoriesList.layoutManager = layoutManager
        repositoriesList.adapter = repositoriesAdapter
    }

    private fun initializeFromIntent() {
        val extra: Parcelable? = intent.getParcelableExtra(StringConstants.EXTRA_KEY_EXAMPLE)
        extra?.let {
            val value = Parcels.unwrap<Int>(it)
            Timber.d("Extra value passed to activity is $value")
        }
    }

}
