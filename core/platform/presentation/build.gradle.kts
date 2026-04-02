plugins {
    alias(libs.plugins.convention.module.presentation)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.platform.domain)
        }
    }
}
