package com.citysearch.shared.feature.citydetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.resources.Res
import com.citysearch.shared.core.resources.city_details_city_label
import com.citysearch.shared.core.resources.city_details_country_label
import com.citysearch.shared.core.resources.city_details_population_label
import com.citysearch.shared.core.resources.city_details_population_value
import com.citysearch.shared.core.resources.city_details_search_info_btn
import com.citysearch.shared.core.resources.city_details_title
import com.citysearch.shared.core.ui.extensions.view.InfoCell
import com.citysearch.shared.core.ui.extensions.view.PrimaryButton
import com.citysearch.shared.core.ui.extensions.view.Toolbar
import com.citysearch.shared.feature.citydetails.presentation.CityDetailsComponent
import org.jetbrains.compose.resources.stringResource
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun CityDetailsScreen(component: CityDetailsComponent) {
    val viewState by component.collectAsState()
    val uriHandler = LocalUriHandler.current

    component.collectSideEffect { effect ->
        when (effect) {
            is CityDetailsComponent.SideEffect.OpenInBrowser -> {
               uriHandler.openUri(effect.uri)
            }
        }
    }

    Column(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Toolbar(
            title = stringResource(Res.string.city_details_title),
            onNavigationBackClick = { component.onNavBackClick() }
        )
        Spacer(Modifier.height(24.dp))

        val contentModifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)

        InfoCell(
            modifier = contentModifier,
            label = stringResource(Res.string.city_details_city_label),
            description = viewState.city.name
        )
        InfoCell(
            modifier = contentModifier,
            label = stringResource(Res.string.city_details_country_label),
            description = viewState.city.country
        )
        // TODO добавить форматирование цифр
        InfoCell(
            modifier = contentModifier,
            label = stringResource(Res.string.city_details_population_label),
            description = stringResource(
                Res.string.city_details_population_value,
                viewState.city.population.toString()
            )
        )
        Spacer(Modifier.weight(1f))
        PrimaryButton(
            modifier = contentModifier,
            text = stringResource(Res.string.city_details_search_info_btn),
            onClick = { component.onSearchInfoClick() }
        )
    }
}