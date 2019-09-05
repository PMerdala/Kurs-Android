package pl.pmerdala.kursandroid.feature.splash;

import org.junit.After;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers

abstract class BaseTest {

    @Before
    open fun setup(){
        MockitoAnnotations.initMocks(this);
    }

    @After
    open fun tearDown(){
        RxAndroidPlugins.reset();
        RxJavaPlugins.reset();
    }

    protected fun trampolineRxPlugin(){
        RxAndroidPlugins.setMainThreadSchedulerHandler {Schedulers.trampoline()}
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setSingleSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
    }
}
