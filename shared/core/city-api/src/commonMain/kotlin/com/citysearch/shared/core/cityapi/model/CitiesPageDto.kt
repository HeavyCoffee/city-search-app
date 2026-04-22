package com.citysearch.shared.core.cityapi.model

import kotlinx.serialization.Serializable

@Serializable
data class CitiesPageDto(
    val items: List<CityDto>,
    val limit: Int,
    val page: Int,
    val total: Int
)