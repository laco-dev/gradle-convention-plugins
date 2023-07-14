/**
 * Not working below code
 * apply("${rfootDir}/common.android.gradle.kts")
 * :: Unresolved reference: android
 */
android {
    defaultConfig {
        minSdk = 24
        compileSdk = 33
    }
    
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
}
