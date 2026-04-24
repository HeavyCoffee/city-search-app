package com.citysearch.shared.feature.navigation.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.citysearch.shared.feature.list.presentation.ListComponent
import com.citysearch.shared.feature.map.presentation.MapComponent
import kotlinx.serialization.Serializable
import org.orbitmvi.orbit.ContainerHost
import com.citysearch.shared.feature.navigation.presentation.BottomNavigationComponent.*

interface BottomNavigationComponent : ContainerHost<State, Nothing> {
    val stack: Value<ChildStack<*, ChildComponent>>

    fun onSearchNavItemClick()
    fun onMapNavItemClick()

    data class State(
        val currentNav: NavItem = NavItem.LIST
    )

    enum class NavItem {
        MAP, LIST
    }

    sealed class ChildComponent {
        data class List(val component: ListComponent) : ChildComponent()
        data class Map(val component: MapComponent) : ChildComponent()
    }

    @Serializable
    sealed class ChildConfig {
        @Serializable
        data object List : ChildConfig()
        @Serializable
        data object Map : ChildConfig()
    }
}