plugins {
    @Suppress("DSL_SCOPE_VIOLATION")
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(project(":core:domain"))
}
