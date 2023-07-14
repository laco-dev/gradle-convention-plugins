package gradle.plugin

import com.android.build.api.dsl.LibraryExtension
import gradle.configure.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AndroidLibraryPlugin : Plugin<Project> {
    
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
        }
        extensions.configure<LibraryExtension> {
            configureKotlinAndroid(this)
            
            defaultConfig {
                consumerProguardFiles("proguard-rules.pro")
            }
        }
    }
}
