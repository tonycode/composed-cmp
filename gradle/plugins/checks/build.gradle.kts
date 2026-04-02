plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

dependencies {
    implementation(libs.ktlint.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("checks-ktlint") {
            id = "convention.checks-ktlint"
            implementationClass = "dev.tonycode.mpcomposed.infra.plugin.checks.KtLintConventionPlugin"
        }
    }
}
