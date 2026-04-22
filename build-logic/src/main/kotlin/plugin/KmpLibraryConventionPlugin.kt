package plugin

import ext.configureMultiplatform
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        apply(plugin = PluginId.kmp)
        apply(plugin = PluginId.kmpAndroidLibrary)

        extensions.configure<KotlinMultiplatformExtension> {
            configureMultiplatform(this)
        }
    }
}