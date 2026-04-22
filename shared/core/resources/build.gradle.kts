import ext.namespace

plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.compose)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.resources)
        }
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = namespace()
    generateResClass = always
}