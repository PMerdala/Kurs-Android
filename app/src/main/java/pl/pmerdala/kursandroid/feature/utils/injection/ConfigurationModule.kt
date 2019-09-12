package pl.pmerdala.kursandroid.feature.utils.injection

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import pl.pmerdala.kursandroid.feature.utils.configuration.ConfigurationImpl

@Module
class ConfigurationModule {
    @Provides
    fun sharedPreferences(context: Context):SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun configuration(sharedPreferences: SharedPreferences): Configuration = ConfigurationImpl(sharedPreferences)
}