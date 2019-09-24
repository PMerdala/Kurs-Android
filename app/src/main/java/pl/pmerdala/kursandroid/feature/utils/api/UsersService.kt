package pl.pmerdala.kursandroid.feature.utils.api

import io.reactivex.Observable
import pl.pmerdala.kursandroid.data.api.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {
    @GET("users/{user}")
    fun user(@Path("user")username:String):Observable<UserResponse>
}