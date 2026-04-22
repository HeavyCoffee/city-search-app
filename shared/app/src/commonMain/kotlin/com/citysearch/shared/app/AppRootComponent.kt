package com.citysearch.shared.app

import androidx.compose.runtime.Composable
import com.citysearch.shared.core.decompose.decompose.ext.AppComponentContext

interface AppRootComponent {
//    val stack: Value<ChildStack<*, FlowComponent>>
}

internal class AppRootComponentImpl(
    componentContext: AppComponentContext
) : AppRootComponent, AppComponentContext by componentContext {
//    private val navigation = StackNavigation<FlowConfig>()

//    override val stack: Value<ChildStack<*, FlowComponent>> = childStack(
//        source = navigation,
//        serializer = FlowConfig.serializer(),
//        initialConfiguration = FlowConfig.Launch,
//        childFactory = ::componentFactory
//    )

//    private fun componentFactory(
//        config: FlowConfig,
//        componentContext: AppComponentContext
//    ): FlowComponent = when (config) {
//        FlowConfig.Launch -> FlowComponent.Launch
//        FlowConfig.Auth -> FlowComponent.Auth()
//        FlowConfig.NavMenu -> FlowComponent.NavMenu()
//    }
}

sealed interface FlowComponent {
    @Composable
    open fun Content() = Unit

    data object Launch : FlowComponent
//
//    data class NavMenu(val component: NavMenuComponent) : FlowComponent {
//        @Composable
//        override fun Content() = component.Content()
//    }
}

//@Serializable
//internal sealed interface FlowConfig {
//    @Serializable
//    data object Launch : FlowConfig
//    @Serializable
//    data object Auth : FlowConfig
//    @Serializable
//    data object NavMenu : FlowConfig
//}