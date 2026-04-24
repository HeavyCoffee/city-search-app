package com.citysearch.shared.feature.list.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.citysearch.shared.core.resources.Res
import com.citysearch.shared.core.resources.city_list_name_country_template
import com.citysearch.shared.core.resources.city_list_search_placeholder
import com.citysearch.shared.core.resources.city_list_title
import com.citysearch.shared.core.resources.common_something_went_wrong_error
import com.citysearch.shared.core.resources.common_update
import com.citysearch.shared.core.ui.extensions.theme.AppTheme
import com.citysearch.shared.core.ui.extensions.view.CityItem
import com.citysearch.shared.core.ui.extensions.view.Divider
import com.citysearch.shared.core.ui.extensions.view.ErrorBanner
import com.citysearch.shared.core.ui.extensions.view.Loader
import com.citysearch.shared.core.ui.extensions.view.SearchField
import com.citysearch.shared.core.ui.extensions.view.Toolbar
import com.citysearch.shared.feature.list.presentation.ListComponent
import org.jetbrains.compose.resources.stringResource
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun SearchScreen(component: ListComponent) {
    val viewState by component.collectAsState()

    Column(
        modifier = Modifier
            .background(AppTheme.colors.backgroundPrimary)
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        Toolbar(
            title = stringResource(Res.string.city_list_title)
        )
        Spacer(Modifier.height(24.dp))
        SearchField(
            modifier = Modifier.padding(horizontal = 16.dp),
            value = viewState.searchText,
            placeholder = stringResource(Res.string.city_list_search_placeholder),
            onValueChange = { component.onQueryChange(it) }
        )

        val cities = viewState.cityPagingData.collectAsLazyPagingItems()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {
            if (cities.loadState.refresh == LoadState.Loading) {
                item {
                    Box(
                        Modifier.fillParentMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Loader()
                    }
                }
            }

            if (cities.loadState.refresh is LoadState.Error) {
                item {
                    ErrorBanner(
                        modifier = Modifier.fillParentMaxSize(),
                        text = stringResource(Res.string.common_something_went_wrong_error),
                        btnText = stringResource(Res.string.common_update),
                        onRetryClick = { cities.retry() }
                    )
                }
            }

            items(
                count = cities.itemCount,
                key = { index -> cities[index]?.id ?: -1 }
            ) { index ->
                cities[index]?.let { city ->
                    if (index > 0) Divider(Modifier.fillMaxWidth())

                    CityItem(
                        text = stringResource(
                            Res.string.city_list_name_country_template,
                            city.name,
                            city.country
                        ),
                        onClick = { component.onClickCityItem(city) }
                    )
                }
            }

            if (cities.loadState.append == LoadState.Loading) {
                item {
                    Box(
                        Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Loader()
                    }
                }
            }

//            if (cities.loadState.append.endOfPaginationReached) {
//                item {
//                    // UI element for last page
//                }
//            }
        }
    }
}