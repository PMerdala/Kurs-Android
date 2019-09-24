package pl.pmerdala.kursandroid.data.api

class RepositoryResponse(
    val name: String,
    val description: String?,
    private val owner: OwnerData

) {
    val imageUrl
        get() = owner.avatar_url
}