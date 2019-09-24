package pl.pmerdala.kursandroid.feature.utils.configuration

import android.content.SharedPreferences
import com.orhanobut.hawk.Hawk

class ConfigurationImpl(
    private var sharedPreferences: SharedPreferences
) : Configuration {
    override fun clear() {
        Hawk.delete(PREFS_KEY_USER_LOGIN)
        sharedPreferences.edit().remove(PREFS_KEY_LOGGED_IN).apply()
    }

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
            if (value.isNotEmpty() && value.isNotBlank()) {
                Hawk.put(PREFS_KEY_USER_LOGIN, value)
                sharedPreferences.edit().putBoolean(PREFS_KEY_LOGGED_IN, true).apply()
            }else{
                clear()
            }
        }
}