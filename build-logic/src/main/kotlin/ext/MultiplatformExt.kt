package ext

import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureMultiplatform(
    extension: KotlinMultiplatformExtension,
) = extension.apply {
    configureAndroidLibrary()
    iosArm64()
    iosSimulatorArm64()
}

internal fun KotlinMultiplatformExtension.androidLibrary(
    block: KotlinMultiplatformAndroidLibraryTarget.() -> Unit
) {
    configure<KotlinMultiplatformAndroidLibraryTarget>(block)
}