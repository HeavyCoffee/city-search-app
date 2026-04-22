package com.citysearch.shared.feature.search

import kotlinx.coroutines.flow.StateFlow
import com.citysearch.shared.feature.search.SearchComponent.*
import org.orbitmvi.orbit.ContainerHost

interface SearchComponent : ContainerHost<State, Effect> {

    val stateFlow: StateFlow<State>

    data class State(
        val isLoading: Boolean = false,
    )

    sealed class Effect {

    }
}
