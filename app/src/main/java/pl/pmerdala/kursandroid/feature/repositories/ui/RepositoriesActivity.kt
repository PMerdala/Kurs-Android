package pl.pmerdala.kursandroid.feature.repositories.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
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

    @BindView(R.id.repositiries_list)
    lateinit var repositoriesList: RecyclerView

    override val layoutId: Int = R.layout.activity_repositories

    val repositoriesAdapter:RepositoriesAdapter = RepositoriesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
        val extra: Parcelable? = intent.getParcelableExtra(StringConstants.EXTRA_KEY_EXAMPLE)
        extra?.let {
            val value = Parcels.unwrap<Int>(it)
            Timber.d("Extra value passed to activity is $value")
        }
    }

    override fun onDestroy() {
        presenter.clear()
        super.onDestroy()
    }

    override fun setList(repositoryDatas: List<RepositoryData>) {
        repositoriesList.adapter = repositoriesAdapter
        repositoriesAdapter.repositoryDatas = repositoryDatas
    }

    inner class RepositoriesAdapter :
        RecyclerView.Adapter<RepositoriesAdapter.RepositoriesViewHolder>() {

        lateinit var repositoryDatas: List<RepositoryData>

        override fun onCreateViewHolder(
            p0: ViewGroup,
            p1: Int
        ): RepositoriesAdapter.RepositoriesViewHolder {
            return RepositoriesViewHolder(
                layoutInflater.inflate(
                    R.layout.repository_list_item,
                    repositoriesList,
                    false
                )
            )
        }

        override fun getItemCount(): Int {
            return repositoryDatas?.size
        }

        override fun onBindViewHolder(
            viewHolder: RepositoriesAdapter.RepositoriesViewHolder,
            position: Int
        ) {
            viewHolder.bindModel((repositoryDatas[position]))
        }

        inner class RepositoriesViewHolder : RecyclerView.ViewHolder {

            constructor(itemView : View):super(itemView){
                ButterKnife.bind(this,itemView)
            }

            @BindView(R.id.repository_title)
            lateinit var title: TextView
            @BindView(R.id.repository_subtitle)
            lateinit var subtitle: TextView


            fun bindModel(repositoryData: RepositoryData) {
                title?.setText(repositoryData.title)
                subtitle?.setText(repositoryData.subtitle)
            }
        }

    }
}
