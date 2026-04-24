plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.decompose)
            implementation(projects.shared.feature.map.api)
            implementation(projects.shared.feature.list.api)
            implementation(projects.shared.feature.cityDetails.api)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.orbit.mviCore)
        }
    }
}
