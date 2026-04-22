package com.citysearch.shared.core.common.system

internal expect fun getBuildType(): BuildType

enum class BuildType {
    DEBUG, RELEASE
}