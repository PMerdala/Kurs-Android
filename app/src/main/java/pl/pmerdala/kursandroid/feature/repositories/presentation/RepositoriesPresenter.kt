package pl.pmerdala.kursandroid.feature.repositories.presentation

import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract

class RepositoriesPresenter(
    private val view: RepositoriesContract.View,
    private val router: RepositoriesContract.Router
) : RepositoriesContract.Presenter {
    override fun initialize() = Unit

    override fun clear() = Unit
}