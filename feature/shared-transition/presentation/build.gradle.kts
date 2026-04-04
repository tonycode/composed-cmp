plugins {
    alias(libs.plugins.convention.module.presentation)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.feature.sharedTransition.domain)
        }
    }
}
