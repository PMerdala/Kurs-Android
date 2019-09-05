package pl.pmerdala.kursandroid.feature.utils.configuration

import android.content.SharedPreferences

class ConfigurationImpl(
    private val sharedPreferences: SharedPreferences
) : Configuration {

    companion object{
        const val PREFS_KEY_LOGGED_IN = "IsUserLoggedIn"
    }

    override fun isUserLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(PREFS_KEY_LOGGED_IN, false)
    }
}