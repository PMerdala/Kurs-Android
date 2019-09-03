package pl.pmerdala.kursandroid.feature.utils.injection

import dagger.Component
import dagger.Module

@Module
class AppModule {

}

@Component(modules = [AppModule::class])
interface AppComponent {

}

