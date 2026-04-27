package com.citysearch.shared.feature.citydetails.presentation

import org.orbitmvi.orbit.ContainerHost
import com.citysearch.shared.feature.citydetails.presentation.CityDetailsComponent.*
import com.citysearch.shared.feature.citydetails.presentation.model.CityDetails

interface CityDetailsComponent : ContainerHost<State, SideEffect> {

    fun onNavBackClick()
    fun onSearchInfoClick()
    data class State(
        val city: CityDetails
    )

    sealed class SideEffect {
        data class OpenInBrowser(val uri: String) : SideEffect()
    }
}