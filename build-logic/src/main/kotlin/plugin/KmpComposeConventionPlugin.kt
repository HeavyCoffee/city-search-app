package plugin

import ext.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class KmpComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        apply(plugin = PluginId.compose)
        apply(plugin = PluginId.composeCompiler)
        apply(plugin = PluginId.kmpAndroidLibrary)
        configureCompose()
    }
}