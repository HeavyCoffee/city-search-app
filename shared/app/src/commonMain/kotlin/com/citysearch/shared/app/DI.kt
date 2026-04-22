package com.citysearch.shared.app

import org.koin.core.annotation.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.plugin.module.dsl.startKoin

object DI {
    fun start(appDeclaration: KoinAppDeclaration = {}) = startKoin<KoinApp> {
        appDeclaration()
    }

    fun start() = start {}
}

@KoinApplication
class KoinApp