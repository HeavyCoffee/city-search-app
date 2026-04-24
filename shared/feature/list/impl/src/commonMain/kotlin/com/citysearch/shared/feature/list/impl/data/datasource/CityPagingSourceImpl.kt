package com.citysearch.shared.feature.list.impl.data.datasource

import androidx.paging.PagingState
import com.citysearch.shared.core.cityapi.api.CityApiService
import com.citysearch.shared.feature.list.domain.datasource.CityPagingSource
import com.citysearch.shared.feature.list.domain.model.City

internal class CityPagingSourceImpl(
    private val api: CityApiService,
    private val query: String
) : CityPagingSource() {
    override fun getRefreshKey(state: PagingState<Int, City>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, City> {
        return try {
            val currentPage = params.key ?: 1
            val response = api.getCities(
                query = query,
                page = currentPage,
                limit = params.loadSize
            )

            with(response) {
                val cities = items.map { city ->
                    City(
                        id = city.id,
                        name = city.name,
                        country = city.country,
                        lat = city.lat,
                        lon = city.lon,
                        pop = city.pop
                    )
                }

                LoadResult.Page(
                    data = cities,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (items.isEmpty() || (currentPage * params.loadSize) >= total) {
                        null
                    } else {
                        currentPage + 1
                    }
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}