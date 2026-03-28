rootProject.name = "plugins"

plugins {
    id("dev.panuszewski.typesafe-conventions") version "0.10.0" // https://github.com/radoslaw-panuszewski/typesafe-conventions-gradle-plugin
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    repositories {
        gradlePluginPortal() // https://plugins.gradle.org
        google { // https://maven.google.com/web/index.html
            mavenContent {
                includeGroupAndSubgroups("android")
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
    }

    versionCatalogs {
        create("libs") {
            from(files("../libs.versions.toml"))
        }
    }
}

include(":conventions")
