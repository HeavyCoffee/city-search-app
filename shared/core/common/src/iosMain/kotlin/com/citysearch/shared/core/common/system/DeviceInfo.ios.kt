package com.citysearch.shared.core.common.system

import platform.UIKit.UIDevice

internal actual fun getDeviceInfo(): DeviceInfo = UIDevice.currentDevice.run {
    DeviceInfo(
        os = systemName,
        osVersion = systemVersion,
        deviceModel = model,
        manufacturer = "Apple"
    )
}