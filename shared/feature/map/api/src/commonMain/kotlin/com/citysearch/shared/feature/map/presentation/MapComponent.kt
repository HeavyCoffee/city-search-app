package com.citysearch.shared.feature.map.presentation

import org.orbitmvi.orbit.ContainerHost
import com.citysearch.shared.feature.map.presentation.MapComponent.*

interface MapComponent : ContainerHost<State, Effect> {

    data class State(
        val isLoading: Boolean = false,
    )

    sealed class Effect {

    }
}