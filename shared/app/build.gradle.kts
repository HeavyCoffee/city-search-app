
plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.compose)
    alias(libs.plugins.buildlogic.kmp.di)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).apply {
        forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "App"
                isStatic = true
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.common)
            implementation(projects.shared.core.ui)
            implementation(projects.shared.core.decompose)
        }
    }
}