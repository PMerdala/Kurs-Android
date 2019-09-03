package pl.pmerdala.kursandroid.feature.utils.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import pl.pmerdala.kursandroid.BaseApplication

@Module
class AppModule {

}

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class]
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

