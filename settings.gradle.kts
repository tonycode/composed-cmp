rootProject.name = "composed-cmp"

@Suppress("UnstableApiUsage")
pluginManagement {
    includeBuild("gradle/plugins")

    repositories {
        google { // https://maven.google.com/web/index.html
            mavenContent {
                includeGroupAndSubgroups("android")
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        gradlePluginPortal() // https://plugins.gradle.org
        // mavenCentral() // https://repo.maven.apache.org/maven2/
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    repositories {
        // https://mvnrepository.com/ - find repository & artifact version for a package

        google { // https://maven.google.com/web/index.html
            mavenContent {
                includeGroupAndSubgroups("android")
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral() // https://repo.maven.apache.org/maven2/
    }
}

// https://docs.gradle.org/9.4.1/userguide/declaring_dependencies_basics.html#sec:type-safe-project-accessors
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
// https://docs.gradle.org/9.4.1/userguide/configuration_cache_enabling.html#config_cache:stable
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

include(":app:androidApp")
include(":app:shared")
include(":core:designsystem")
include(":core:platform:domain")
include(":core:platform:presentation")
include(":feature:haptic:jindong:ui")
