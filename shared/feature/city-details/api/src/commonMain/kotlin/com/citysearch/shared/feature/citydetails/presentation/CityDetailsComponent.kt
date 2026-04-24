package com.citysearch.shared.feature.citydetails.presentation

import org.orbitmvi.orbit.ContainerHost
import com.citysearch.shared.feature.citydetails.presentation.CityDetailsComponent.*
import com.citysearch.shared.feature.citydetails.presentation.model.CityDetails

interface CityDetailsComponent : ContainerHost<State, Nothing> {

    fun onNavBackClick()
    fun onSearchInfoClick()
    data class State(
        val city: CityDetails
    )
}