package com.citysearch.shared.core.cityapi.model

import kotlinx.serialization.Serializable

@Serializable
data class CityDto(
    val id: Int,
    val name: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val pop: Int
)