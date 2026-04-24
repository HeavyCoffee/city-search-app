import ext.namespace

plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.compose)
}

kotlin {
    android {
        androidResources { enable = true }
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            api(libs.compose.resources)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = namespace()
    generateResClass = always
}