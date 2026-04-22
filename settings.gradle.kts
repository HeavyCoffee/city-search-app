import kotlin.text.replace

rootProject.name = "CitySearch"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

internal fun Settings.includeProjects(
    ignoreDirs: Set<String>,
    depth: Int = 5
) {
    val excludePatterns = listOf("^[.]".toRegex())

    fun isBuildGradleFile(file: File): Boolean {
        return file.name == "build.gradle.kts"
    }

    fun isAvailableDir(file: File): Boolean {
        return ignoreDirs.contains(file.name).not() && file != rootDir
    }

    fun getProjectPath(projectDir: File): String {
        return ":" + projectDir
            .relativeTo(rootDir)
            .invariantSeparatorsPath
            .replace('/', ':')
    }

    rootDir
        .walk()
        .maxDepth(depth)
        .filter { file -> isBuildGradleFile(file) }
        .map { it.parentFile }
        .filter { dir ->
            excludePatterns.any { pattern ->
                !pattern.containsMatchIn(dir.name)
            } && isAvailableDir(dir)
        }
        .forEach { dir ->
            include(
                getProjectPath(dir).also {
                    println(it)
                }
            )
        }
}

includeProjects(setOf("build-logic", "ios-app", "build", "gradle"))

includeBuild("build-logic")