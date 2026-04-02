plugins {
    // Avoid the plugins to be loaded multiple times in each subproject's classloader

    alias(libs.plugins.kotlinMultiplatform) apply false

    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false

    alias(libs.plugins.androidMultiplatformLibrary) apply false
    alias(libs.plugins.androidApplication) apply false

    // Plugins for Gradle build-logic
    alias(libs.plugins.gradleDoctor)
}

doctor {
    javaHome {
        failOnError.set(false)
    }
}

//region tasks
// Generates gradle-wrapper via `gradle wrapper`.
tasks.wrapper {
    gradleVersion = libs.versions.gradle.get()
    distributionType = Wrapper.DistributionType.ALL
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
//endregion
