package com.citysearch.shared.core.network

import io.ktor.client.HttpClient
import io.ktor.http.HttpHeaders
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module
import org.koin.core.annotation.Singleton

@Module
@ComponentScan
@Configuration
class CoreNetworkModule {
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(
        HttpClientFactory(
            // TODO вынести в конфиги
            baseUrl = "http://dev-dep.tools.urent.tech:8080",
            headers = mapOf(HttpHeaders.Accept to "application/json; charset=utf-8")
        )
    )
}