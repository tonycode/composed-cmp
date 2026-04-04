plugins {
    alias(libs.plugins.convention.module.ui)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.feature.sharedTransition.data) // TODO: Introduce DI for data-modules
            implementation(projects.feature.sharedTransition.domain)
            implementation(projects.feature.sharedTransition.presentation)
        }
    }
}
