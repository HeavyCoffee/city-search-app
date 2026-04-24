package com.citysearch.shared.feature.navigation.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.citysearch.shared.feature.citydetails.presentation.CityDetailsComponent
import com.citysearch.shared.feature.list.domain.model.City
import kotlinx.serialization.Serializable

interface NavigationComponent {
    val stack: Value<ChildStack<*, ChildComponent>>

    sealed class ChildComponent {
        data class BottomNavigation(val component: BottomNavigationComponent) : ChildComponent()
        data class CityDetails(val component: CityDetailsComponent) : ChildComponent()
    }

    @Serializable
    sealed class ChildConfig {
        @Serializable
        data object BottomNavigation : ChildConfig()
        @Serializable
        data class CityDetails(val city: City) : ChildConfig()
    }
}