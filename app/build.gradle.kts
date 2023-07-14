plugins {
    id("convention.android.application")
    id("convention.android.compose")
}

android {
    namespace = "com.laco.gradle.conventions"
    
    defaultConfig {
        applicationId = "com.laco.gradle.conventions"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:designsystem"))
    implementation(project(":feature:setting"))
    implementation(project(":feature:home"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)

    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
