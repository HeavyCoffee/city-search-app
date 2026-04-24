plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.list.api)
            implementation(projects.shared.core.ui)
            implementation(projects.shared.core.resources)
            implementation(libs.orbit.mviCompose)
            implementation(libs.androidx.pagingCompose)
        }
    }
}
