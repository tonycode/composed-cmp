package dev.tonycode.mpcomposed.infra.plugin.checks

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jlleitschuh.gradle.ktlint.KtlintExtension

class KtLintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jlleitschuh.gradle.ktlint")

            extensions.configure<KtlintExtension> {
                version.set("1.8.0") // https://github.com/pinterest/ktlint/releases
                android.set(true)
                enableExperimentalRules.set(true)

                filter {
                    exclude("${project.layout.buildDirectory}/generated/**")
                    exclude("**/generated/**")
                    exclude("**/build/**/ksp/**")
                    exclude("**/build/**/kapt/**")
                }
            }

            // Do NOT use ktlintCheckAll – it breaks CC and ignores filters
            tasks.matching { it.name == "ktlintCheckAll" }.configureEach {
                enabled = false
            }
        }
    }
}
