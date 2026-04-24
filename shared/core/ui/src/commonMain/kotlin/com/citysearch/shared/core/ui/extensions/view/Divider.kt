package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.ui.extensions.theme.AppTheme

@Composable
fun Divider(modifier: Modifier) {
    Spacer(
        modifier
            .background(color = AppTheme.colors.dividerPrimary)
            .height(1.dp)
    )
}