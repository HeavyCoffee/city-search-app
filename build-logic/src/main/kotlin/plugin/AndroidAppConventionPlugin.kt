package plugin

import PluginId
import com.android.build.api.dsl.ApplicationExtension
import ext.configureAndroidApp
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidAppConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        apply(plugin = PluginId.androidApp)
        apply(plugin = PluginId.compose)
        apply(plugin = PluginId.composeCompiler)

        extensions.configure<ApplicationExtension> {
            configureAndroidApp()
            packaging {
                resources {
                    excludes += "/META-INF/{AL2.0,LGPL2.1}"
                }
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                }
            }
        }
    }
}