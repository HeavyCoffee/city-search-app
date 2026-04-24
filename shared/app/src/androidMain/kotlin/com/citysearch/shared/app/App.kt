package com.citysearch.shared.app

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.retainedComponent
import com.citysearch.shared.core.decompose.decompose.AppComponentContext
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

fun ComponentActivity.initApp() {
    val rootComponent: AppRootComponent by retainedComponent(key = "RetainedComponent") {
        val appComponentContext = get<AppComponentContext> { parametersOf(it) }
        inject<AppRootComponent> { parametersOf(appComponentContext) }
    }
    setContent {
        AppRootScreen(rootComponent)
    }
}