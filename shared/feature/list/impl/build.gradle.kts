plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.di)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.feature.list.api)
            implementation(projects.shared.core.decompose)
            implementation(libs.orbit.mviCore)
            implementation(projects.shared.core.cityApi)
            implementation(libs.androidx.pagingCommon)
        }
    }
}