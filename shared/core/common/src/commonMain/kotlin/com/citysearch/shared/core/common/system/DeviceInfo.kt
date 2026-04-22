package com.citysearch.shared.core.common.system

internal expect fun getDeviceInfo(): DeviceInfo

data class DeviceInfo(
    val os: String,
    val osVersion: String,
    val deviceModel: String,
    val manufacturer: String
)