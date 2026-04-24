package com.citysearch.shared.feature.list.domain.datasource

import androidx.paging.PagingSource
import com.citysearch.shared.feature.list.domain.model.City

abstract class CityPagingSource : PagingSource<Int, City>()