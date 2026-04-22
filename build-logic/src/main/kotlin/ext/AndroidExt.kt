package ext

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import kotlin.jvm.java

internal fun Project.configureAndroidApp() {
    extensions.configure(ApplicationExtension::class.java) {
        namespace = namespace()
        compileSdk = androidCompileSdk()
        defaultConfig {
            minSdk = androidMinSdk()
            targetSdk = androidTargetSdk()
            versionCode = versionCode()
            versionName = versionName()
        }
        compileOptions {
            sourceCompatibility = javaVersion()
            targetCompatibility = javaVersion()
        }
    }
}

internal fun Project.configureAndroidLibrary() {
    extensions.configure(KotlinMultiplatformExtension::class.java) {
        androidLibrary {
            namespace = namespace()
            compileSdk = androidCompileSdk()
            minSdk = androidMinSdk()
            compilerOptions.jvmTarget.set(jvmTarget())
            withHostTestBuilder {}.configure {
                enableCoverage = true
            }
        }
    }
}