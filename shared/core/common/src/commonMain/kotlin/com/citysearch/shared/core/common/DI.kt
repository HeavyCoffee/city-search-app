package com.citysearch.shared.core.common

import com.citysearch.shared.core.common.system.AppBuildInfo
import com.citysearch.shared.core.common.system.getBuildType
import com.citysearch.shared.core.common.system.getDeviceInfo
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
@ComponentScan
@Configuration
class CoreCommonModule {
    @Singleton
    fun provideAppBuildInfo(): AppBuildInfo = AppBuildInfo(
        buildType = getBuildType(),
        deviceInfo = getDeviceInfo()
    )
}