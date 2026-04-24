package com.citysearch.shared.feature.list.domain.repository

import androidx.paging.PagingData
import com.citysearch.shared.feature.list.domain.model.City
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    fun searchCity(query: String): Flow<PagingData<City>>
}