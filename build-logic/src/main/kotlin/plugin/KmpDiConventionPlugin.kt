package plugin

import PluginId
import ext.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpDiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        apply(plugin = PluginId.kmp)
        apply(plugin = PluginId.koinCompiler)

        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.commonMain.dependencies {
                implementation(project.dependencies.platform(library("koin-bom")))
                implementation(library("koin-core"))
                implementation(library("koin-compose"))
                implementation(library("koin-annotations"))
            }
            sourceSets.androidMain.dependencies {
                implementation(project.dependencies.platform(library("koin-bom")))
                implementation(library("koin-android"))
            }
        }
    }
}