package com.citysearch.shared.core.network

data class ApiConfig(
    val baseUrl: String
) {
    companion object {
        internal fun getReleaseConfig() = ApiConfig("https://api.soundcloud.com")
    }
}
