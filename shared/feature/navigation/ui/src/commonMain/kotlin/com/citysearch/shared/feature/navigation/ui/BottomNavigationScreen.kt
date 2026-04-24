package com.citysearch.shared.feature.navigation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.citysearch.shared.core.resources.Res
import com.citysearch.shared.core.resources.ic_list
import com.citysearch.shared.core.resources.ic_map
import com.citysearch.shared.core.ui.extensions.theme.AppTheme
import com.citysearch.shared.core.ui.extensions.view.BottomNavBar
import com.citysearch.shared.core.ui.extensions.view.NavItem
import com.citysearch.shared.feature.list.ui.SearchScreen
import com.citysearch.shared.feature.map.ui.MapScreen
import com.citysearch.shared.feature.navigation.presentation.BottomNavigationComponent
import org.jetbrains.compose.resources.painterResource
import org.orbitmvi.orbit.compose.collectAsState

@Composable
fun BottomNavigationScreen(component: BottomNavigationComponent) {
    val viewState by component.collectAsState()

    Column(
        modifier = Modifier
            .background(color = AppTheme.colors.backgroundPrimary)
            .systemBarsPadding()
            .fillMaxSize()
    ) {
        Children(
            modifier = Modifier.fillMaxSize().weight(1f),
            stack = component.stack,
            animation = stackAnimation(fade())
        ) {
            when (val instance = it.instance) {
                is BottomNavigationComponent.ChildComponent.List -> {
                    SearchScreen(instance.component)
                }
                is BottomNavigationComponent.ChildComponent.Map -> {
                    MapScreen(instance.component)
                }
            }
        }

        BottomNavBar(
            modifier = Modifier.dropShadow(
                shape = RectangleShape,
                shadow = Shadow(
                    radius = 2.dp,
                    color = Color.Black.copy(alpha = .15f),
                    spread = 0.dp,
                    offset = DpOffset(0.dp, (-2).dp)
                )
            )
        ) {
            NavItem(
                painter = painterResource(Res.drawable.ic_list),
                isSelected = viewState.currentNav == BottomNavigationComponent.NavItem.LIST,
                onClick = { component.onSearchNavItemClick() }
            )
            NavItem(
                painter = painterResource(Res.drawable.ic_map),
                isSelected = viewState.currentNav == BottomNavigationComponent.NavItem.MAP,
                onClick = { component.onMapNavItemClick() }
            )
        }
    }
}
