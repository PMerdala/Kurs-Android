package pl.pmerdala.kursandroid

import android.app.Activity
import android.app.Application
import com.crashlytics.android.Crashlytics
import com.orhanobut.hawk.Hawk
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import pl.pmerdala.kursandroid.feature.utils.injection.DaggerAppComponent
import javax.inject.Inject

abstract class BaseApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        Fabric.with(this,Crashlytics())
        initTimber()
        initDaggerComponent()
    }

    private fun initDaggerComponent() {
        DaggerAppComponent.builder()
            .bindApplication(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> =
        activityInjector

    abstract fun initTimber()
}