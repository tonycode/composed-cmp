plugins {
    alias(libs.plugins.convention.module.domain)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.serialization.core) // to make nav routes serializable
            api(libs.navigation3.common) // narrowed from navigation3-ui just for NavKey interface
        }
    }
}
