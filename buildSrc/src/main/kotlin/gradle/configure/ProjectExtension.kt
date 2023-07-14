package gradle.configure

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.android(action: CommonExtension<*, *, *, *>.() -> Unit) {
    val androidExtension = extensions.getByName("android")
    if (androidExtension is CommonExtension<*, *, *, *>) {
        androidExtension.apply(action)
    }
}
