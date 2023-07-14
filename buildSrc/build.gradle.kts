plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.hilt.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "convention.android.application"
            implementationClass = "gradle.plugin.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "convention.android.library"
            implementationClass = "gradle.plugin.AndroidLibraryPlugin"
        }
        register("androidHilt") {
            id = "convention.android.hilt"
            implementationClass = "gradle.plugin.AndroidHiltPlugin"
        }
        register("androidCompose") {
            id = "convention.android.compose"
            implementationClass = "gradle.plugin.AndroidComposePlugin"
        }
        register("androidFeature") {
            id = "convention.android.feature"
            implementationClass = "gradle.plugin.AndroidFeaturePlugin"
        }
    }
}
