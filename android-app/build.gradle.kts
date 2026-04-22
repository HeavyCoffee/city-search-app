plugins {
    alias(libs.plugins.buildlogic.android.app)
}

dependencies {
    implementation(projects.shared.app)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.android)
}