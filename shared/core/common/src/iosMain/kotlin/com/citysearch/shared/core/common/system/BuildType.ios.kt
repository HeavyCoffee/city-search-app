package com.citysearch.shared.core.common.system

import kotlin.experimental.ExperimentalNativeApi

@OptIn(ExperimentalNativeApi::class)
internal actual fun getBuildType(): BuildType =
    if (Platform.isDebugBinary) BuildType.DEBUG else BuildType.RELEASE
