package pl.pmerdala.kursandroid

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

abstract class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Fabric.with(this,Crashlytics())
    }
}