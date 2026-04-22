import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    alias(libs.plugins.androidMultiplatformLibrary)

    id("convention.checks-ktlint")
}

kotlin {
    android {
        namespace = "dev.tonycode.mpcomposed${project.path.replace(":", ".")}"

        compileSdk = libs.versions.android.compileSdk.get().toInt()
        buildToolsVersion = libs.versions.buildTools.get()
        minSdk = libs.versions.android.minSdk.get().toInt()

        // Enable host tests to create a test compilation that uses commonTest
        withHostTest {}
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvmToolchain(libs.versions.java.get().toInt())

    sourceSets {
        commonMain {
            dependencies {
                // Each UI module has access to DesignSystem
                if (path != ":core:designsystem") {
                    implementation(project(":core:designsystem"))
                }
                // Each UI module has access to Navigation routes
                implementation(project(":core:navigation"))
                // For Platform-specific branching
                implementation(project(":core:platform:domain"))

                // Compose dependencies
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.materialIconsCore)
                implementation(libs.compose.ui)
                implementation(libs.compose.uiToolingPreview)
                implementation(libs.lifecycle.viewmodel.compose)
                // Navigation 3
                implementation(libs.navigation3.ui)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }

    @OptIn(ExperimentalAbiValidation::class)
    abiValidation()
}

dependencies {
    // ui-tooling is required for the Compose Preview to render in Android Studio.
    androidRuntimeClasspath(libs.compose.uiTooling)
}
