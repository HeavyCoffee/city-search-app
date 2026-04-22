package com.citysearch.shared.feature.navigation.impl

import com.citysearch.shared.core.decompose.decompose.ext.AppComponentContext
import com.citysearch.shared.core.decompose.decompose.ext.reducer
import com.citysearch.shared.feature.search.SearchComponent
import kotlinx.coroutines.flow.StateFlow

class NavigationComponent(
    componentContext: AppComponentContext,
) : SearchComponent, AppComponentContext by componentContext {

    private val stateReducer = reducer<SearchComponent.State, Nothing>(
        initialState = SearchComponent.State()
    )

    override val stateFlow: StateFlow<SearchComponent.State> = stateReducer.state
}
