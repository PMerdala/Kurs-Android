package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.pmerdala.kursandroid.feature.utils.configuration.Configuration
import pl.pmerdala.kursandroid.feature.utils.configuration.ConfigurationImpl

@Module
class ConfigurationModule {
    @Provides
    fun configuration(): Configuration = ConfigurationImpl()
}