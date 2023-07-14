import gradle.configure.libs

plugins {
    id("convention.android.library")
    id("convention.android.compose")
    id("convention.android.hilt")
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:designsystem"))
    
    testImplementation(libs.findLibrary("junit4").get())
    androidTestImplementation(libs.findLibrary("androidx.test.ext").get())
    androidTestImplementation(libs.findLibrary("androidx.test.espresso.core").get())
}
