package pl.pmerdala.kursandroid.feature.repositories.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.pmerdala.kursandroid.R
import pl.pmerdala.kursandroid.data.RepositoryData

class RepositoriesAdapter(private val data: MutableList<RepositoryData>) :
    RecyclerView.Adapter<RepositoriesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.repository_list_item, parent, false)
        return RepositoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(
        viewHolder: RepositoriesViewHolder,
        position: Int
    ) {
        viewHolder.bindModel((data[position]))
    }

    fun updateData(data: List<RepositoryData>) {
        this.data.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

}
