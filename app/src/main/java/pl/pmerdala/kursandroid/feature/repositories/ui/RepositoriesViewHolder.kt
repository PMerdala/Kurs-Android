package pl.pmerdala.kursandroid.feature.repositories.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.data.RepositoryData

class RepositoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.repository_title)
    lateinit var titleTextView: TextView
    @BindView(R.id.repository_subtitle)
    lateinit var subtitleTextView: TextView
    @BindView(R.id.repository_image_view)
    lateinit var imageView:ImageView

    init {
        ButterKnife.bind(this, itemView)
    }


    fun bindModel(repositoryData: RepositoryData) = with(repositoryData) {
        titleTextView.text = title
        subtitleTextView.text = subtitle
    }
}
