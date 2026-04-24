package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.ui.extensions.theme.AppTheme

@Composable
fun Loader(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier.size(40.dp),
        color = AppTheme.colors.accentBrand,
        trackColor = AppTheme.colors.backgroundBrand
    )
}

@Preview
@Composable
private fun Preview() {
    Loader()
}