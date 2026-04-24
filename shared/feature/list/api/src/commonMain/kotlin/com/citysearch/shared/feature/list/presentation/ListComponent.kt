package com.citysearch.shared.feature.list.presentation

import androidx.paging.PagingData
import com.citysearch.shared.feature.list.domain.model.City
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.orbitmvi.orbit.ContainerHost
import com.citysearch.shared.feature.list.presentation.ListComponent.*

interface ListComponent : ContainerHost<State, Effect> {

    fun onQueryChange(query: String)
    fun onClickCityItem(city: City)

    data class State(
        val searchText: String = "",
        val cityPagingData: Flow<PagingData<City>> = emptyFlow()
    )

    sealed class Effect {

    }
}