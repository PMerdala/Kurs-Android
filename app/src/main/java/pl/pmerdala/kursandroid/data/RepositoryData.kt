package pl.pmerdala.kursandroid.data

import com.google.gson.annotations.SerializedName

data class RepositoryData (
    @SerializedName("name")
    val title:String,
    @SerializedName("full_name")
    val subtitle:String,
    @SerializedName("avatar_url")
    val avatarUrl:String
){
    override fun toString(): String {
        return "RepositoryData(title='$title')"
    }
}