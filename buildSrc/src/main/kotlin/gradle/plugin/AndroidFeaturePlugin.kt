package gradle.plugin

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal class AndroidFeaturePlugin : Plugin<Project> {
    
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("convention.android.library")
            apply("convention.android.hilt")
            apply("convention.android.compose")
        }
        
        extensions.configure<LibraryExtension> {
            defaultConfig {
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }
        
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
        dependencies {
            "implementation"(project(":core:domain"))
            "implementation"(project(":core:designsystem"))
            
            "testImplementation"(libs.findLibrary("junit4").get())
            "androidTestImplementation"(libs.findLibrary("androidx.test.ext").get())
            "androidTestImplementation"(libs.findLibrary("androidx.test.espresso.core").get())
        }
    }
}
