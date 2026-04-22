plugins {
    alias(libs.plugins.buildlogic.kmp.library)
    alias(libs.plugins.buildlogic.kmp.di)
}
kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.decompose)
            api(libs.decompose.composeExt)
            api(libs.essenty.lifecylce)
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}