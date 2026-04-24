plugins {
    alias(libs.plugins.buildlogic.kmp.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core.decompose)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.orbit.mviCore)
        }
    }
}
