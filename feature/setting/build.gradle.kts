plugins {
    id("convention.android.feature")
}

android {
    namespace = "com.laco.gradle.conventions.feature.setting"
}

dependencies {
    implementation(libs.androidx.activity.compose)
}
