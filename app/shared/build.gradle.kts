plugins {
    alias(libs.plugins.convention.module.ui)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.navigation)
            implementation(projects.feature.haptic.jindong.ui)
            implementation(projects.feature.showcases.ui)

            implementation(libs.kotlinx.serialization.core) // for navBackStack serialization
        }
    }
}
