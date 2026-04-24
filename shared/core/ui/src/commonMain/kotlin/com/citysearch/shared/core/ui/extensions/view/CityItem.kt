package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.resources.Res
import com.citysearch.shared.core.resources.ic_location
import com.citysearch.shared.core.ui.extensions.theme.AppTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun CityItem(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .height(54.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(Res.drawable.ic_location),
            contentDescription = "Location pin icon",
            colorFilter = ColorFilter.tint(AppTheme.colors.iconSecondary)
        )

        Text(
            text = text,
            style = AppTheme.typography.titleMedium,
            color = AppTheme.colors.textPrimary
        )
    }
}

@Preview
@Composable
private fun Preview() {
    CityItem(
        text = "Moscow, Russia",
        onClick = {}
    )
}