package com.citysearch.shared.core.cityapi.api

import com.citysearch.shared.core.cityapi.model.CitiesPageDto
import com.citysearch.shared.core.cityapi.model.CityMapResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
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
                parameters.append("query", query)
                parameters.append("page", page.toString())
                parameters.append("limit", limit.toString())
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
                parameters.append("radius", radius.toString())
                parameters.append("centerLat", centerLat.toString())
                parameters.append("centerLng", centerLng.toString())
            }
        }.body()
    }
}