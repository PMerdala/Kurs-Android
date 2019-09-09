package pl.pmerdala.kursandroid.feature.utils.injection

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.reactivex.disposables.CompositeDisposable
import pl.pmerdala.kursandroid.BaseApplication
import pl.pmerdala.kursandroid.feature.tools.parcel.ParcelableProvider
import pl.pmerdala.kursandroid.feature.tools.parcel.ParcelableProviderImpl
import pl.pmerdala.kursandroid.feature.tools.permissions.PermissionsHelper
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    fun context(app:Application): Context = app

    @Provides
    fun compositeDisposable():CompositeDisposable
            = CompositeDisposable()

    @Provides
    fun parcelableProvider():ParcelableProvider
            = ParcelableProviderImpl()

}

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBinderModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(app: Application): Builder
        fun build():AppComponent
    }

    fun inject(app:BaseApplication)
}

