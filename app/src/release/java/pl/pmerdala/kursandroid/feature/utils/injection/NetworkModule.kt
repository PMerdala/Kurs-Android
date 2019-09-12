package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {
    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient = OkHttpClient()
}