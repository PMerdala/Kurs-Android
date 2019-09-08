package pl.pmerdala.kursandroid.feature.repositories.presentation

import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract

class RepositoriesPresenter(
    view: RepositoriesContract.View,
    router: RepositoriesContract.Router
) : RepositoriesContract.Presenter {
    override fun initialize() = Unit

    override fun clear() = Unit
}