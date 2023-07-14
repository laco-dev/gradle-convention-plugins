plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = "${rootDir}/shared/gradle/common/common.android.library.gradle")

android {
    namespace = "com.laco.gradle.conventions.core.data"
}
