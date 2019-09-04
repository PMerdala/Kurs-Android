object Versions{
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
    const val compilerSdk =28
    const val minSdk = 17
    const val targetSdk = 28
    const val versionCode = 1
    const val versionName = "1.0"
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
    const val butterKnifeAnnotationProcessor  = "com.jakewharton:butterknife-compiler:${Versions.butterKnife}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
}

object ClassPaths{
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val fabricPlugin = "io.fabric.tools:gradle:${Versions.fabricPlugin}"
}