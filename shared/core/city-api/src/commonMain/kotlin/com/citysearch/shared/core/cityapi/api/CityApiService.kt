package com.citysearch.shared.core.cityapi.api

import com.citysearch.shared.core.cityapi.model.CitiesPageDto
import com.citysearch.shared.core.cityapi.model.CityMapResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.koin.core.annotation.Factory

@Factory
class CityApiService(
    private val httpClient: HttpClient
) {
    suspend fun getCities(
        query: String,
        page: Int,
        limit: Int
    ): CitiesPageDto {
        return httpClient.get("api/cities") {
            url {
                parameter("query", query)
                parameter("page", page)
                parameter("limit", limit)
            }
        }.body()
    }

    suspend fun getCitiesByRadius(
        radius: Int,
        centerLat: Long,
        centerLng: Long
    ): CityMapResponseDto {
        return httpClient.get("api/cities/map") {
            url {
                parameter("radius", radius)
                parameter("centerLat", centerLat)
                parameter("centerLng", centerLng)
            }
        }.body()
    }
}