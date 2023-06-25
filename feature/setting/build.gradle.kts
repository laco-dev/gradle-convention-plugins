import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.laco.gradle.conventions.feature.setting"

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
    implementation(project(":core:domain"))
    implementation(project(":core:designsystem"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    testImplementation(libs.junit4)

    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)

    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)

    coreLibraryDesugaring(libs.android.desugarJdkLibs)
}
