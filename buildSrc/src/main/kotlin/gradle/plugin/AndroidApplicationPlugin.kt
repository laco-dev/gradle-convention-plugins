package gradle.plugin

import com.android.build.api.dsl.ApplicationExtension
import gradle.configure.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationPlugin : Plugin<Project> {
    
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
            apply("convention.android.hilt")
        }
        
        extensions.configure<ApplicationExtension> {
            configureKotlinAndroid(this)
            
            buildTypes {
                release {
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }
}
