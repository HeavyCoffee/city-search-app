package com.citysearch.shared.feature.map

import com.citysearch.shared.feature.map.MapComponent.Effect
import com.citysearch.shared.feature.map.MapComponent.State
import org.orbitmvi.orbit.ContainerHost

interface MapComponent : ContainerHost<State, Effect> {

    data class State(
        val isLoading: Boolean = false,
    )

    sealed class Effect {

    }
}