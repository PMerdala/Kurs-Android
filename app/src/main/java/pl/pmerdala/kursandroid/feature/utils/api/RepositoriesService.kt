package pl.pmerdala.kursandroid.feature.utils.api

import io.reactivex.Observable
import pl.pmerdala.kursandroid.data.RepositoryData
import retrofit2.http.GET
import retrofit2.http.Path

interface RepositoriesService {
    @GET("/users/{user}/repos")
    fun repositories(@Path("user")username:String):Observable<List<RepositoryData>>
}