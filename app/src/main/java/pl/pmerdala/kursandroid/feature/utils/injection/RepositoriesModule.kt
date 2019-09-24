package pl.pmerdala.kursandroid.feature.utils.injection

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.pmerdala.kursandroid.data.RepositoryData
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
import pl.pmerdala.kursandroid.feature.repositories.navigation.RepositoriesRouter
import pl.pmerdala.kursandroid.feature.repositories.presentation.RepositoriesPresenter
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.pmerdala.kursandroid.feature.repositories.ui.RepositoriesAdapter
import pl.pmerdala.kursandroid.feature.utils.api.RepositoriesService
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import retrofit2.Retrofit

@Module
class RepositoriesModule {

    @Provides
    fun repositoriesService(retrofit: Retrofit): RepositoriesService =
        retrofit.create(RepositoriesService::class.java)

    @Provides
    fun layoutManager(activity: RepositoriesActivity): RecyclerView.LayoutManager =
        LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    @Provides
    fun data():MutableList<RepositoryData> = ArrayList()

    @Provides
    fun adapter(data:MutableList<RepositoryData>)= RepositoriesAdapter(data)

    @Provides
    fun router(): RepositoriesContract.Router = RepositoriesRouter()

    @Provides
    fun presenter(
        activity: RepositoriesActivity,
        router: RepositoriesContract.Router,
        repositoriesService: RepositoriesService,
        configuration: Configuration,
        compositeDisposable: CompositeDisposable
    ): RepositoriesContract.Presenter = RepositoriesPresenter(
        activity,
        router,
        repositoriesService,
        configuration,
        compositeDisposable
    )
}