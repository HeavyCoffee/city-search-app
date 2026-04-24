package com.citysearch.shared.core.ui.extensions.view

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.citysearch.shared.core.ui.extensions.theme.AppTheme

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    contentPaddings: PaddingValues = PaddingValues(
        vertical = 15.dp,
        horizontal = 42.dp
    ),
    colors: PrimaryButtonColors = PrimaryButtonColors.defaultColors(),
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val backgroundColor by animateColorAsState(
        targetValue = if (isPressed) colors.backgroundPressed else colors.background
    )

    Row(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                role = Role.Button,
                onClick = onClick
            )
            .clip(RoundedCornerShape(16.dp))
            .drawBehind { drawRect(backgroundColor) }
            .padding(contentPaddings),
        horizontalArrangement = Arrangement.Center
    ) {
        BasicText(
            text = text,
            style = AppTheme.typography.headlineSmall,
            color = { colors.content }
        )
    }
}

data class PrimaryButtonColors(
    val background: Color,
    val backgroundPressed: Color,
    val content: Color
) {
    internal companion object {
        @Composable
        @ReadOnlyComposable
        fun defaultColors() = PrimaryButtonColors(
            background = AppTheme.colors.buttonPrimaryBackground,
            backgroundPressed = AppTheme.colors.buttonPrimaryBackgroundPressed,
            content = AppTheme.colors.buttonPrimaryForeground
        )
    }
}

@Preview
@Composable
private fun Preview() {
    PrimaryButton(
        modifier = Modifier.fillMaxWidth(),
        text = "Test",
        onClick = {}
    )
}