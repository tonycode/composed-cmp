plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(projects.checks)

    implementation(libs.kotlin.gradlePlugin) // to access "kotlin" plugin in kts code
}
