plugins {
    alias(libs.plugins.convention.module.ui)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.platform.presentation)

            implementation(libs.jindong.compose)
        }
    }
}
