plugins {
    alias(libs.plugins.kotlinMultiplatform)
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
    )

    jvmToolchain(libs.versions.java.get().toInt())

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
