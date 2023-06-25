import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.laco.gradle.conventions.core.domain"
    
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
    
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    buildTypes {
        release {
            isMinifyEnabled = true
            consumerProguardFiles("proguard-rules.pro")
        }
    }
    
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }
    
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.majorVersion
        }
    }
}

dependencies {
    implementation(project(":core:data"))
    coreLibraryDesugaring(libs.android.desugarJdkLibs)
}
