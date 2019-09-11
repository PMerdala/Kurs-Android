package pl.pmerdala.kursandroid.feature.utils.configuration

import com.orhanobut.hawk.Hawk

class ConfigurationImpl() : Configuration {

    companion object{
        const val PREFS_KEY_LOGGED_IN = "IsUserLoggedIn"
        const val PREFS_KEY_USER_LOGIN = "UserLogin"
    }

    override val exampleExtra: Int = 12

    override fun isUserLoggedIn(): Boolean {
        return Hawk.get<Boolean>(PREFS_KEY_LOGGED_IN, false)
    }
    override var usertLogin: String
        get()=Hawk.get<String>(PREFS_KEY_USER_LOGIN, "")
        set(value){
            Hawk.put(PREFS_KEY_USER_LOGIN,value)
            Hawk.put(PREFS_KEY_USER_LOGIN,true)
        }
}