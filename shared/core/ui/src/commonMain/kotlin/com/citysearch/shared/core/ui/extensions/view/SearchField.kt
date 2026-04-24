package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.resources.Res
import com.citysearch.shared.core.resources.ic_search
import com.citysearch.shared.core.ui.extensions.theme.AppTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun SearchField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    colors: SearchFieldColors = SearchFieldColors.defaultColors()
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val shape = RoundedCornerShape(16.dp)
    val transition = updateTransition(isFocused)
    val backgroundColor by transition.animateColor { isFocused ->
        if (isFocused) colors.backgroundFocused else colors.background
    }
    val borderColor by transition.animateColor { isFocused ->
        if (isFocused) colors.borderFocused else colors.border
    }

    BasicTextField(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        interactionSource = interactionSource,
        textStyle = AppTheme.typography.titleMedium.copy(color = colors.content),
        cursorBrush = SolidColor(colors.cursor),
        singleLine = true,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .clip(shape = shape)
                    .fillMaxSize()
                    .background(backgroundColor)
                    .border(border = BorderStroke(width = 1.dp, color = borderColor), shape = shape)
                    .padding(vertical = 17.dp, horizontal = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (value.isBlank()) {
                    Text(
                        modifier = Modifier.fillMaxWidth().weight(1f),
                        text = placeholder,
                        style = AppTheme.typography.titleMedium,
                        color = colors.placeholder,
                        maxLines = 1
                    )
                } else {
                    Box(Modifier.weight(1f)) { innerTextField() }
                }

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(Res.drawable.ic_search),
                    contentDescription = "Search icon",
                    colorFilter = ColorFilter.tint(AppTheme.colors.iconPrimary)
                )
            }
        }
    )
}

data class SearchFieldColors(
    val background: Color,
    val backgroundFocused: Color,
    val border: Color,
    val borderFocused: Color,
    val placeholder: Color,
    val content: Color,
    val cursor: Color
) {
    internal companion object {
        @Composable
        @ReadOnlyComposable
        fun defaultColors() = SearchFieldColors(
            background = AppTheme.colors.backgroundTertiary,
            backgroundFocused = AppTheme.colors.backgroundPrimary,
            border = Color.Transparent,
            borderFocused = AppTheme.colors.accentBrand,
            placeholder = AppTheme.colors.textTertiary,
            content = AppTheme.colors.textPrimary,
            cursor = AppTheme.colors.accentBrand
        )
    }
}

@Preview
@Composable
private fun Preview() {
    SearchField(
        value = "",
        placeholder = "Placeholder",
        onValueChange = {}
    )
}