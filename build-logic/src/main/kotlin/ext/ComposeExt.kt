package ext

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

fun Project.configureCompose() {
    dependencies {
        add(
            "androidRuntimeClasspath",
            library("compose-uiTooling")
        )
    }
}