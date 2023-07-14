plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = "${rootDir}/shared/gradle/common/common.android.library.gradle")
apply(from = "${rootDir}/shared/gradle/common/common.android.compose.gradle")

android {
    namespace = "com.laco.gradle.conventions.core.designsystem"
}
