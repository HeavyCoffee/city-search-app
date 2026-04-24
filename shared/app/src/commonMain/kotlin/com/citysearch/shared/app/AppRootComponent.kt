package com.citysearch.shared.app

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.citysearch.shared.core.decompose.decompose.AppComponentContext
import com.citysearch.shared.feature.navigation.presentation.NavigationComponent
import com.citysearch.shared.feature.navigation.ui.NavigationScreen
import kotlinx.serialization.Serializable
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Singleton
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

interface AppRootComponent : KoinComponent {
    val stack: Value<ChildStack<*, ChildComponent>>
}

@Singleton(binds = [AppRootComponent::class])
internal class AppRootComponentImpl(
    @InjectedParam componentContext: AppComponentContext
) : AppRootComponent, AppComponentContext by componentContext {
    private val navigation = StackNavigation<ChildConfig>()

    override val stack: Value<ChildStack<*, ChildComponent>> = childStack(
        source = navigation,
        serializer = ChildConfig.serializer(),
        initialConfiguration = ChildConfig.Navigation,
        childFactory = ::componentFactory
    )

    private fun componentFactory(
        config: ChildConfig,
        componentContext: AppComponentContext
    ): ChildComponent = when (config) {
        ChildConfig.Navigation -> ChildComponent.Navigation(
            get{ parametersOf(componentContext) }
        )
    }
}

sealed class ChildComponent {
    @Composable
    abstract fun Content()
    data class Navigation(
        val component: NavigationComponent
    ) : ChildComponent() {
        @Composable
        override fun Content() {
            NavigationScreen(component)
        }
    }
}

@Serializable
internal sealed class ChildConfig {
    @Serializable
    data object Navigation : ChildConfig()
}