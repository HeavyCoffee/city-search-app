package com.citysearch.shared.feature.navigation

import com.citysearch.shared.feature.navigation.NavigationComponent.State
import org.orbitmvi.orbit.ContainerHost

interface NavigationComponent : ContainerHost<State, Nothing> {

    data class State(
        val isLoading: Boolean = false,
    )
}