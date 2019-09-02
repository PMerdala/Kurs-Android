object Versions{
    const val kotlin = "1.3.31"
    const val support = "28.0.0"
    const val junit = "4.12"
    const val testRunner = "1.0.2"
    const val espressoCore = "3.0.2"
    const val compilerSdk =28
    const val minSdk = 17
    const val targetSdk = 28
    val versionCode = 1
    val versionName = "1.0"
}

object Libs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val supportAppcompat = "com.android.support:appcompat-v7:${Versions.support}"
    const val supportRecycler = "com.android.support:recyclerview-v7:${Versions.support}"
    const val junit = "junit:junit:${Versions.junit}"
    const val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    const val espressoCore =
        "com.android.support.test.espresso:espresso-core:${Versions.espressoCore}"
}