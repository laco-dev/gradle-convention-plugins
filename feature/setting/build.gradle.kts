plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = "${rootDir}/shared/gradle/common/common.android.feature.gradle")

android {
    namespace = "com.laco.gradle.conventions.feature.setting"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
}
