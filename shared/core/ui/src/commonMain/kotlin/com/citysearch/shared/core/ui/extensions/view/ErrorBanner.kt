package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.ui.extensions.theme.AppTheme

@Composable
fun ErrorBanner(
    text: String,
    modifier: Modifier = Modifier,
    btnText: String? = null,
    onRetryClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = text,
            style = AppTheme.typography.titleMedium,
            color = AppTheme.colors.textPrimary
        )

        if (btnText != null && onRetryClick != null) {
            PrimaryButton(
                text = btnText,
                onClick = onRetryClick
            )
        }
    }
}