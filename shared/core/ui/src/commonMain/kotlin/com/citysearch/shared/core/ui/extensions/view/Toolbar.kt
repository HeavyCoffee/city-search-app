package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.resources.Res
import com.citysearch.shared.core.resources.ic_nav_back
import com.citysearch.shared.core.ui.extensions.theme.AppTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun Toolbar(
    title: String,
    modifier: Modifier = Modifier,
    onNavigationBackClick: (() -> Unit)? = null,
) {
    val isBackButtonVisible = onNavigationBackClick != null

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = if (isBackButtonVisible) Alignment.Start else Alignment.CenterHorizontally
        )
    ) {
        if (isBackButtonVisible) {
            Image(
                modifier = Modifier
                    .clickable(onClick = onNavigationBackClick)
                    .size(24.dp),
                painter = painterResource(Res.drawable.ic_nav_back),
                contentDescription = "Navigation back icon",
                colorFilter = ColorFilter.tint(AppTheme.colors.iconPrimary)
            )
        }
        Text(
            text = title,
            style = AppTheme.typography.headlineMedium,
            maxLines = 1,
            color = AppTheme.colors.textPrimary
        )
    }
}

@Preview
@Composable
private fun Preview() {
    Toolbar(
        title = "Test title",
        onNavigationBackClick = {}
    )
}