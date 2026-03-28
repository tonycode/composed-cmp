plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    alias(libs.plugins.androidMultiplatformLibrary)
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
                implementation(project(":core:platform"))

                implementation(libs.kotlin.stdlib)
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
                implementation(libs.compose.uiToolingPreview)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

dependencies {
    // ui-tooling is required for the Compose Preview to render in Android Studio.
    androidRuntimeClasspath(libs.compose.uiTooling)
}
