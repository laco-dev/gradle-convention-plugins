package gradle.plugin

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType

internal class AndroidComposePlugin : Plugin<Project> {
    
    override fun apply(target: Project) = with(target) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        val android = extensions.findByType<LibraryExtension>()
            ?: extensions.findByType<ApplicationExtension>()
        
        android?.run {
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
    }
}
