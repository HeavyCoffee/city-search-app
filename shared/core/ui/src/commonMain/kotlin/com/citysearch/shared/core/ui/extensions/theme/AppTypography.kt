package com.citysearch.shared.core.ui.extensions.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class AppTypography(
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,
    val titleMedium: TextStyle,
    val bodyLarge: TextStyle,
    val labelSmall: TextStyle
)

val LocalAppTypography = staticCompositionLocalOf {
    AppTypography(
        headlineMedium = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 26.sp
        ),
        headlineSmall = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            lineHeight = 26.sp
        ),
        titleMedium = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 22.sp
        ),
        bodyLarge = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 22.sp
        ),
        labelSmall = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            lineHeight = 18.sp
        )
    )
}