package pl.pmerdala.kursandroid.data

data class RepositoryData (
    val title:String,
    val subtitle:String,
    val imageUrl:String
){
    override fun toString(): String {
        return "RepositoryData(title='$title')"
    }
}