package com.citysearch.shared.core.cityapi.model

import kotlinx.serialization.Serializable

@Serializable
data class CityMapResponseDto(
    val items: List<CityDto>,
    val count: Int
)