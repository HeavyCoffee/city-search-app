plugins {
    alias(libs.plugins.kotlin.gradle.jvm)
    `kotlin-dsl`
}

dependencies {
    implementation(libs.plugin.kotlin.gradle)
    implementation(libs.plugin.android)
    implementation(libs.plugin.openapi.generator)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin {
    val pluginPrefix = "build-logic"
    val pluginPath = "plugin"

    plugins {
        register("KmpComposePlugin") {
            id = "$pluginPrefix.kmp.compose"
            implementationClass = "$pluginPath.KmpComposeConventionPlugin"
        }
        register("KmpLibraryPlugin") {
            id = "$pluginPrefix.kmp.library"
            implementationClass = "$pluginPath.KmpLibraryConventionPlugin"
        }
        register("KmpDiConventionPlugin") {
            id = "$pluginPrefix.kmp.di"
            implementationClass = "$pluginPath.KmpDiConventionPlugin"
        }
        register("AndroidAppConventionPlugin") {
            id = "$pluginPrefix.android.app"
            implementationClass = "$pluginPath.AndroidAppConventionPlugin"
        }
    }
}

group = "build-logic"