package pl.pmerdala.kursandroid.data

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("login")
    val username:String
){
}