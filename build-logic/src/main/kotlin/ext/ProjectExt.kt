package ext

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

internal fun Project.libs(): VersionCatalog =
    extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.version(name: String) =
    libs().findVersion(name).get().requiredVersion
internal fun Project.library(name: String) =
    libs().findLibrary(name).get()
internal fun Project.domain() = version("domain")
fun Project.namespace() = "${domain()}${path.replace(":", ".").replace("-", "")}"
internal fun Project.androidMinSdk() = version("android-minSdk").toInt()
internal fun Project.androidTargetSdk() = version("android-targetSdk").toInt()
internal fun Project.androidCompileSdk() = version("android-compileSdk").toInt()
internal fun Project.versionCode() = version("version-code").toInt()
internal fun Project.versionName() = "${ version("version-name")}(${ versionCode() })"
internal fun Project.jvmTarget() = JvmTarget.fromTarget(version("java-version"))
internal fun Project.javaVersionInt() = jvmTarget().target.toInt()
internal fun Project.javaVersion() = JavaVersion.toVersion(javaVersionInt())
internal fun Project.javaLanguageVersion() = JavaLanguageVersion.of(javaVersionInt())