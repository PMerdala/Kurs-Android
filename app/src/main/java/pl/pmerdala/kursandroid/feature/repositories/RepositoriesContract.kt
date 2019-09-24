package pl.pmerdala.kursandroid.feature.repositories

import pl.pmerdala.kursandroid.data.RepositoryData
import pl.pmerdala.kursandroid.feature.commons.BaseContract

class RepositoriesContract:BaseContract {
    interface View{
        fun updateRepos(repositoryDatas: List<RepositoryData>);
    }
    interface Presenter:BaseContract.Presenter
    interface Router
}