package com.citysearch.shared.core.ui.extensions.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import com.citysearch.shared.core.ui.extensions.indication.NoIndication

@Immutable
object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current
}

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    // задел на смену темы
    CompositionLocalProvider(
        LocalAppColors provides LocalAppColors.current,
        LocalAppTypography provides LocalAppTypography.current,
        LocalIndication provides NoIndication,
        content = content
    )
}