package com.citysearch.shared.feature.list.impl.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.citysearch.shared.core.cityapi.api.CityApiService
import com.citysearch.shared.feature.list.domain.model.City
import com.citysearch.shared.feature.list.domain.repository.CityRepository
import com.citysearch.shared.feature.list.impl.data.datasource.CityPagingSourceImpl
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory(binds = [CityRepository::class])
internal class CityRepositoryImpl(
    private val api: CityApiService
) : CityRepository {
    override fun searchCity(query: String): Flow<PagingData<City>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CityPagingSourceImpl(api, query) }
        ).flow
    }
}