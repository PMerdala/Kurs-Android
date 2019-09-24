package pl.pmerdala.kursandroid.feature.repositories.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.pmerdala.kursandroid.data.RepositoryData
import pl.pmerdala.kursandroid.feature.repositories.RepositoriesContract
import pl.pmerdala.kursandroid.feature.utils.api.RepositoriesService
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import timber.log.Timber

class RepositoriesPresenter(
    private val view: RepositoriesContract.View,
    private val router: RepositoriesContract.Router,
    private val repositoriesService: RepositoriesService,
    private val configuration:Configuration,
    private val compositeDisposable: CompositeDisposable
) : RepositoriesContract.Presenter {

    override fun initialize() {
        val userLogin = configuration.usertLogin
        compositeDisposable.add(
            repositoriesService
                .repositories(userLogin)
                .distinct()
                .flatMapIterable { it }
                .map { RepositoryData(
                    it.name,
                    it.description?:"",
                    it.imageUrl
                    )
                }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {view.updateRepos(it)
                    Timber.d("Rozmiar przesłanych danych ${it.size}")},
                    {Timber.e(it)}
                )
        )
    }

    override fun clear() {
        compositeDisposable.clear()
    }
    override fun logoutClicked() {
        configuration.clear()
        router.navigateToLogin()
    }
}