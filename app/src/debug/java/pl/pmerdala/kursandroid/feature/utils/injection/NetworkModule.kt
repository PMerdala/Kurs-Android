package pl.pmerdala.kursandroid.feature.utils.injection

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {

    @Named("Stetho")
    @Provides
    fun stethoInterceptor():Interceptor = StethoInterceptor()

    @Named("Chuck")
    @Provides
    fun chuckInterceptor(context: Context): Interceptor = ChuckInterceptor(context)

    @Singleton
    @Provides
    fun okHttpClient(
        @Named("Chuck")chuckInterceptor: Interceptor,
        @Named("Stetho") stethoInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addNetworkInterceptor(chuckInterceptor)
            .addNetworkInterceptor(stethoInterceptor)
            .build()
}