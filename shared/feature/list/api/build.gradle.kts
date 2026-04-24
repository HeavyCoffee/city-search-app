plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.decompose)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.orbit.mviCore)
            implementation(libs.androidx.pagingCommon)
        }
    }
}
