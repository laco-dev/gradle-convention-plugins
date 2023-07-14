plugins {
    id("convention.android.feature")
}

android {
    namespace = "com.laco.gradle.conventions.feature.home"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
}
