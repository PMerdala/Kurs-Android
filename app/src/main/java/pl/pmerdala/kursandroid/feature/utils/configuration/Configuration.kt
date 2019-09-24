package pl.pmerdala.kursandroid.feature.utils.configuration

interface Configuration {
    fun isUserLoggedIn():Boolean
    fun clear()
    var usertLogin: String
    val exampleExtra: Int
}