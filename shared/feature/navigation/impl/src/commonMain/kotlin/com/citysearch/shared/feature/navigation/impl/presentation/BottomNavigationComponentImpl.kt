package com.citysearch.shared.feature.navigation.impl.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.citysearch.shared.core.decompose.decompose.AppComponentContext
import com.citysearch.shared.core.decompose.decompose.ext.componentScope
import com.citysearch.shared.feature.list.domain.model.City
import com.citysearch.shared.feature.navigation.presentation.BottomNavigationComponent
import com.citysearch.shared.feature.navigation.presentation.BottomNavigationComponent.ChildComponent
import com.citysearch.shared.feature.navigation.presentation.BottomNavigationComponent.ChildConfig
import com.citysearch.shared.feature.navigation.presentation.BottomNavigationComponent.NavItem
import com.citysearch.shared.feature.navigation.presentation.BottomNavigationComponent.State
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container

@Factory(binds = [BottomNavigationComponent::class])
class BottomNavigationComponentImpl(
    @InjectedParam componentContext: AppComponentContext,
    @InjectedParam private val onCitySelected: (City) -> Unit
) : BottomNavigationComponent, KoinComponent, AppComponentContext by componentContext {

    override val container: Container<State, Nothing> = componentScope.container(State())
    private val navigation = StackNavigation<ChildConfig>()

    override val stack: Value<ChildStack<*, ChildComponent>> = childStack(
        source = navigation,
        serializer = ChildConfig.serializer(),
        initialConfiguration = ChildConfig.List,
        childFactory = ::componentFactory
    )

    override fun onMapNavItemClick() {
        intent {
            navigation.bringToFront(ChildConfig.Map)

            reduce {
                state.copy(currentNav = NavItem.MAP)
            }
        }
    }

    override fun onSearchNavItemClick() {
        intent {
            navigation.bringToFront(ChildConfig.List)
            reduce {
                state.copy(currentNav = NavItem.LIST)
            }
        }
    }

    private fun componentFactory(
        config: ChildConfig,
        appComponentContext: AppComponentContext
    ): ChildComponent = when (config) {
        ChildConfig.List -> ChildComponent.List(
            get {
                parametersOf(
                    appComponentContext,
                    onCitySelected
                )
            }
        )
        ChildConfig.Map -> ChildComponent.Map(
            get { parametersOf(appComponentContext) }
        )
    }
}