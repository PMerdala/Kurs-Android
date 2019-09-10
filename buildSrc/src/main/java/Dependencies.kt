object Versions {
    const val kotlin = "1.3.31"
    const val support = "28.0.0"
    const val junit = "4.12"
    const val testRunner = "1.0.2"
    const val espressoCore = "3.0.2"
    const val gradlePlugin = "3.5.0"
    const val fabricPlugin = "1.+"
    const val timber = "4.7.1"
    const val crashlytics = "2.10.1@aar"
    const val leakcanary = "1.5.4"
    const val butterKnife = "8.8.1"
    const val dagger = "2.14.1"
    const val mockito = "2.16.0"
    const val hawk = "2.0.1"
    const val compilerSdk = 28
    const val minSdk = 17
    const val targetSdk = 28
    const val versionCode = 1
    const val versionName = "1.0"
    const val rxJava = "2.2.12"
    const val rxAndroid = "2.1.1"
//    const val powermock = "2.0.2"
    const val mockitoKotlin = "1.6.0"
    const val parceler = "1.1.12"
    const val lottie = "2.7.0"
    const val rxPermission = "0.10.2"
    const val rxBinding="2.2.0"
}

object Libs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val supportAppcompat = "com.android.support:appcompat-v7:${Versions.support}"
    const val supportRecycler = "com.android.support:recyclerview-v7:${Versions.support}"
    const val junit = "junit:junit:${Versions.junit}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    const val espressoCore =
        "com.android.support.test.espresso:espresso-core:${Versions.espressoCore}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
    const val butterKnife = "com.jakewharton:butterknife:${Versions.butterKnife}"
    const val butterKnifeAnnotationProcessor =
        "com.jakewharton:butterknife-compiler:${Versions.butterKnife}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidProcessor =
        "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val hawk = "com.orhanobut:hawk:${Versions.hawk}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
//    const val powermockApi = "org.powermock:powermock-api-mockito2:${Versions.powermock}"
//    const val powermockJunit = "org.powermock:powermock-module-junit4:${Versions.powermock}"
//    const val powermockRuleAgent =
//        "org.powermock:powermock-module-junit4-rule-agent:${Versions.powermock}"
    const val mockitoKotlin = "com.nhaarman:mockito-kotlin-kt1.1:${Versions.mockitoKotlin}"
    const val parcelerApi = "org.parceler:parceler-api:${Versions.parceler}"
    const val parcelerProcessor = "org.parceler:parceler:${Versions.parceler}"
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    const val rxPermission = "com.github.tbruyelle:rxpermissions:${Versions.rxPermission}"
    const val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Versions.rxBinding}"
}

object ClassPaths {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val fabricPlugin = "io.fabric.tools:gradle:${Versions.fabricPlugin}"
}