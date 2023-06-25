plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.laco.gradle.conventions.feature.home"

    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}
