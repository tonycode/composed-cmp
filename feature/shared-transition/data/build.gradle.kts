plugins {
    alias(libs.plugins.convention.module.data)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(projects.feature.sharedTransition.domain)
        }
    }
}
