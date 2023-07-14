import gradle.configure.android
import gradle.configure.libs

android {
    buildFeatures.compose = true
    composeOptions.kotlinCompilerExtensionVersion =
        libs.findVersion("androidxComposeCompiler").get().toString()
}

dependencies {
    val bom = libs.findLibrary("androidx-compose-bom").get()
    "implementation"(platform(bom))
    "androidTestImplementation"(platform(bom))
    
    "implementation"(libs.findLibrary("androidx.compose.material3").get())
    "implementation"(libs.findLibrary("androidx.compose.ui").get())
    "implementation"(libs.findLibrary("androidx.compose.ui.tooling.preview").get())
    "androidTestImplementation"(libs.findLibrary("androidx.test.ext").get())
    "androidTestImplementation"(libs.findLibrary("androidx.test.espresso.core").get())
    "androidTestImplementation"(libs.findLibrary("androidx.compose.ui.test").get())
    "debugImplementation"(libs.findLibrary("androidx.compose.ui.tooling").get())
    "debugImplementation"(libs.findLibrary("androidx.compose.ui.testManifest").get())
}
