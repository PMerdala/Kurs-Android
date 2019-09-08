package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
import pl.pmerdala.kursandroid.feature.repositories.navigation.RepositoriesRouter
import pl.pmerdala.kursandroid.feature.repositories.presentation.RepositoriesPresenter

@Module
class RepositoriesModule {
    @Provides
    fun router(): RepositoriesContract.Router = RepositoriesRouter()

    @Provides
    fun presenter():RepositoriesContract.Presenter = RepositoriesPresenter()
}