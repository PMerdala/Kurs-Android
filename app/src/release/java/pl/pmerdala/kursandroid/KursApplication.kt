package pl.pmerdala.kursandroid

import timber.log.Timber


class KursApplication : BaseApplication(){
    override fun initTimber() {
        Timber.plant(ReleaseTree())
    }
}