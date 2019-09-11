package pl.pmerdala.kursandroid.feature.utils.configuration

interface Configuration {
    fun isUserLoggedIn():Boolean
    var usertLogin: String
    val exampleExtra: Int
}