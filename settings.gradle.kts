pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "gradle-convention-plugins"
include(
    ":app",
    ":core:data",
    ":core:designsystem",
    ":core:domain",

    ":feature:home",
    ":feature:setting",
)
