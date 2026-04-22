plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.navigation.api)
            implementation(projects.shared.core.ui)
            implementation(libs.orbit.mviCompose)
        }
    }
}
