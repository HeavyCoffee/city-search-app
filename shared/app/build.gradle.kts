
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
            implementation(libs.orbit.mviCore)
            implementation(projects.shared.core.common)
            implementation(projects.shared.core.ui)
            implementation(projects.shared.core.decompose)
            implementation(projects.shared.core.cityApi)
            implementation(projects.shared.core.network)
            implementation(projects.shared.feature.list.impl)
            implementation(projects.shared.feature.map.impl)
            implementation(projects.shared.feature.cityDetails.impl)
            implementation(projects.shared.feature.navigation.api)
            implementation(projects.shared.feature.navigation.impl)
            implementation(projects.shared.feature.navigation.ui)
        }
    }
}