package com.citysearch.shared.core.network.di

//val koinNetworkModule = module {
//    single<ApiConfig> {
//        when(get<AppBuildInfo>().buildType) {
//            BuildType.DEBUG,
//            BuildType.RELEASE -> ApiConfig.getReleaseConfig()
//        }
//    }
//    single<HttpClient> {
//        HttpClient(
//            HttpClientFactory(
//                baseUrl = get<ApiConfig>().baseUrl,
//                headers = mapOf(HttpHeaders.Accept to "application/json; charset=utf-8"),
//                bearerProvider = getOrNull()
//            )
//        )
//    }
//}