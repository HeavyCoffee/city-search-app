plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.navigation.api)
            implementation(projects.shared.feature.list.api)
            implementation(projects.shared.feature.map.api)
            implementation(projects.shared.feature.cityDetails.api)
            implementation(projects.shared.core.decompose)
            implementation(libs.orbit.mviCore)
        }
    }
}
