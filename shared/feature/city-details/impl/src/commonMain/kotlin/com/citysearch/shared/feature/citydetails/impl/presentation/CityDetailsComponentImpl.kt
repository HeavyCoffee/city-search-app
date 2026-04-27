package com.citysearch.shared.feature.citydetails.impl.presentation

import com.citysearch.shared.core.decompose.decompose.AppComponentContext
import com.citysearch.shared.core.decompose.decompose.ext.componentScope
import com.citysearch.shared.feature.citydetails.presentation.CityDetailsComponent
import com.citysearch.shared.feature.citydetails.presentation.CityDetailsComponent.*
import com.citysearch.shared.feature.citydetails.presentation.model.CityDetails
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.container

@Factory(binds = [CityDetailsComponent::class])
class CityDetailsComponentImpl(
    @InjectedParam componentContext: AppComponentContext,
    @InjectedParam private val city: CityDetails,
    @InjectedParam private val onBackClicked: () -> Unit
) : CityDetailsComponent, AppComponentContext by componentContext {
    override val container: Container<State, SideEffect> =
        componentScope.container(State(city))

    override fun onNavBackClick() {
        onBackClicked()
    }

    override fun onSearchInfoClick() {
        intent {
            postSideEffect(
                SideEffect.OpenInBrowser(GOOGLE_SEARCH_URI + state.city.name)
            )
        }
    }

    // В идеале можно вынести это в бизнесс слой
    private companion object {
        const val GOOGLE_SEARCH_URI = "https://www.google.com/search?q="
    }
}