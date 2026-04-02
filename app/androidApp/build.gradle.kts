plugins {
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    alias(libs.plugins.androidApplication)
}

kotlin {
    jvmToolchain(libs.versions.java.get().toInt())

    dependencies {
        implementation(projects.core.designsystem)
        implementation(projects.app.shared)

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(libs.compose.uiToolingPreview)
    }
}

android {
    namespace = "dev.tonycode.mpcomposed"

    defaultConfig {
        applicationId = "dev.tonycode.mpcomposed"
        versionCode = 1
        versionName = "1.0.0"
        base.archivesName = "ComposedCMP-v$versionName-build_$versionCode"

        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()

        @Suppress("UnstableApiUsage")
        androidResources.localeFilters += listOf("en")
    }

    compileSdk = libs.versions.android.compileSdk.get().toInt()
    buildToolsVersion = libs.versions.buildTools.get()

    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }

        release {
            // signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            // https://developer.android.com/studio/build/shrink-code
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    // ui-tooling is required for the Compose Preview to render in Android Studio.
    debugImplementation(libs.compose.uiTooling)
}
