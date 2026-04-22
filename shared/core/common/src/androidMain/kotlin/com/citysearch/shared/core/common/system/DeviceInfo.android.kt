package com.citysearch.shared.core.common.system

import android.os.Build

internal actual fun getDeviceInfo(): DeviceInfo = DeviceInfo(
    os = "Android",
    osVersion = Build.VERSION.RELEASE,
    deviceModel = Build.MODEL,
    manufacturer = Build.MANUFACTURER
)