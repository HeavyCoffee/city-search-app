package com.citysearch.shared.feature.map.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.citysearch.shared.core.ui.extensions.view.Text
import com.citysearch.shared.feature.map.presentation.MapComponent

@Composable
fun MapScreen(component: MapComponent) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Не допилил")
    }
}