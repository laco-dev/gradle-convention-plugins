import gradle.configure.configureKotlinAndroid

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    configureKotlinAndroid(this)
    
    defaultConfig {
        consumerProguardFiles("proguard-rules.pro")
    }
}
