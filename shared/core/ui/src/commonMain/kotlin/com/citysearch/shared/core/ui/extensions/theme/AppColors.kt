package com.citysearch.shared.core.ui.extensions.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val backgroundPrimary: Color,
    val backgroundTertiary: Color,
    val backgroundBrand: Color,
    val buttonPrimaryBackground: Color,
    val buttonPrimaryBackgroundPressed: Color,
    val buttonPrimaryForeground: Color,
    val accentBrand: Color,
    val iconPrimary: Color,
    val iconSecondary: Color,
    val textPrimary: Color,
    val textTertiary: Color,
    val dividerPrimary: Color,
    val pinsForeground: Color,
    val pinsPrimaryBackground: Color
)

internal val LocalAppColors = staticCompositionLocalOf {
    AppColors(
        backgroundPrimary = Color(0xFFFFFFFF),
        backgroundTertiary = Color(0xFFF6F6F7),
        backgroundBrand = Color(0xFFF5EDFF),
        buttonPrimaryBackground = Color(0xFF804AFF),
        buttonPrimaryBackgroundPressed = Color(0xFF683BD3),
        buttonPrimaryForeground = Color(0xFFFFFFFF),
        accentBrand = Color(0xFF804AFF),
        iconPrimary = Color(0xFF25222B),
        iconSecondary = Color(0xFF777381),
        textPrimary = Color(0xFF25222B),
        textTertiary = Color(0xFFA5A2AB),
        dividerPrimary = Color(0xFFEFEFF0),
        pinsForeground = Color(0xFFFFFFFF),
        pinsPrimaryBackground = Color(0xFF4A4557)
    )
}