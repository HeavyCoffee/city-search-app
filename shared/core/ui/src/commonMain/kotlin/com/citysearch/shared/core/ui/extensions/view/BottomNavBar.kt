package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.resources.Res
import com.citysearch.shared.core.resources.ic_list
import com.citysearch.shared.core.resources.ic_map
import com.citysearch.shared.core.ui.extensions.theme.AppTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    colors: BottomNavBarColors = BottomNavBarColors.defaultColors(),
    content: @Composable BottomNavBarScope.() -> Unit
) {
    Row(
        modifier = modifier
            .height(64.dp)
            .fillMaxWidth()
            .background(color = colors.background),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(
            LocalBottomNavBarColors provides colors
        ) {
            BottomNavBarScopeImpl(this).content()
        }
    }
}

@Immutable
interface BottomNavBarScope : RowScope
private class BottomNavBarScopeImpl(rowScope: RowScope): BottomNavBarScope, RowScope by rowScope

@Composable
fun BottomNavBarScope.NavItem(
    painter: Painter,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalBottomNavBarColors.current
    val transaction = updateTransition(isSelected)
    val iconColor by transaction.animateColor { isSelected ->
        if (isSelected) colors.iconSelected else colors.icon
    }
    val pillColor by transaction.animateColor { isSelected ->
        if (isSelected) colors.pillSelected else colors.pill
    }

    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .weight(1f),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .size(64.dp, 32.dp)
                .background(color = pillColor, shape = RoundedCornerShape(50))
                .padding(vertical = 4.dp, horizontal = 20.dp),
            painter = painter,
            contentDescription = "Nav icon",
            colorFilter = ColorFilter.tint(iconColor)
        )
    }
}

data class BottomNavBarColors(
    val icon: Color,
    val iconSelected: Color,
    val pill: Color,
    val pillSelected: Color,
    val background: Color
) {
    internal companion object {
        @Composable
        fun defaultColors() = BottomNavBarColors(
            icon = AppTheme.colors.iconSecondary,
            iconSelected = AppTheme.colors.accentBrand,
            pill = Color.Transparent,
            pillSelected = AppTheme.colors.backgroundBrand,
            background = AppTheme.colors.backgroundPrimary
        )
    }
}

private val LocalBottomNavBarColors = staticCompositionLocalOf<BottomNavBarColors> { error("Can not be null") }

@Preview
@Composable
private fun Preview() {
    BottomNavBar {
        NavItem(
            painter = painterResource(Res.drawable.ic_list),
            isSelected = false,
            onClick = {}
        )
        NavItem(
            painter = painterResource(Res.drawable.ic_map),
            isSelected = true,
            onClick = {}
        )
    }
}