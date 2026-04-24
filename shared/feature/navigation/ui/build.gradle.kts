plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.orbit.mviCompose)
            implementation(projects.shared.core.ui)
            implementation(projects.shared.core.resources)
            implementation(projects.shared.core.decompose)
            implementation(projects.shared.feature.navigation.api)
            implementation(projects.shared.feature.list.api)
            implementation(projects.shared.feature.list.ui)
            implementation(projects.shared.feature.map.api)
            implementation(projects.shared.feature.map.ui)
            implementation(projects.shared.feature.cityDetails.api)
            implementation(projects.shared.feature.cityDetails.ui)
        }
    }
}
