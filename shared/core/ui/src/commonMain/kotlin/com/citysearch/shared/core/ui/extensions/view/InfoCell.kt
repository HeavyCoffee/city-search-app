package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.ui.extensions.theme.AppTheme

@Composable
fun InfoCell(
    label: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(66.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = label,
            maxLines = 1,
            style = AppTheme.typography.titleMedium
        )
        Text(
            text = description,
            maxLines = 1,
            style = AppTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun Preview() {
    InfoCell(
        label = "Label",
        description = "Description"
    )
}