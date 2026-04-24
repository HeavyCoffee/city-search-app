package com.citysearch.shared.feature.list.impl.presentation

import androidx.paging.cachedIn
import com.citysearch.shared.core.decompose.decompose.AppComponentContext
import com.citysearch.shared.core.decompose.decompose.ext.componentScope
import com.citysearch.shared.feature.list.presentation.ListComponent
import com.citysearch.shared.feature.list.domain.repository.CityRepository
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import com.citysearch.shared.feature.list.presentation.ListComponent.*
import com.citysearch.shared.feature.list.domain.model.City
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.container

@Factory(binds = [ListComponent::class])
internal class ListComponentImpl(
    @InjectedParam componentContext: AppComponentContext,
    @InjectedParam private val onCitySelected: (City) -> Unit,
    private val cityRepository: CityRepository
) : ListComponent, AppComponentContext by componentContext {

    private val querySearchFlow = MutableSharedFlow<String>()

    @OptIn(FlowPreview::class)
    override val container = componentScope.container<State, Effect>(State()) {
        componentScope.launch {
            repeatOnSubscription {
                querySearchFlow
                    .distinctUntilChanged()
                    .debounce(QUERY_INPUT_DELAY_MS)
                    .collect { updatePagingData(it) }
            }
        }
        coroutineScope {
            launch { updatePagingData("") }
        }
    }

    override fun onQueryChange(query: String) {
        intent {
            querySearchFlow.emit(query)
            reduce { state.copy(searchText = query) }
        }
    }

    override fun onClickCityItem(city: City) {
        onCitySelected(city)
    }

    @OptIn(OrbitExperimental::class)
    private suspend fun updatePagingData(query: String) = subIntent {
        val data = cityRepository.searchCity(query)
            .cachedIn(componentScope)

        reduce {
           state.copy(cityPagingData = data)
        }
    }

    private companion object {
        const val QUERY_INPUT_DELAY_MS = 500L
    }
}