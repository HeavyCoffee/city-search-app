package com.citysearch.shared.core.ui.extensions.indication

import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode

internal object NoIndication : IndicationNodeFactory {
    override fun create(interactionSource: InteractionSource): DelegatableNode {
        return NoIndicationInstance()
    }

    override fun equals(other: Any?): Boolean = other === this

    override fun hashCode(): Int = -1

    private class NoIndicationInstance() : Modifier.Node(), DrawModifierNode {
        override fun ContentDrawScope.draw() {
            drawContent()
        }
    }
}