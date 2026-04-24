package com.citysearch.shared.feature.navigation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.citysearch.shared.feature.citydetails.ui.CityDetailsScreen
import com.citysearch.shared.feature.navigation.presentation.NavigationComponent

@Composable
fun NavigationScreen(component: NavigationComponent) {
    Children(
        modifier = Modifier.fillMaxSize(),
        stack = component.stack,
        animation = stackAnimation(fade() + scale())
    ) {
        when (val instance = it.instance) {
            is NavigationComponent.ChildComponent.BottomNavigation -> {
                BottomNavigationScreen(instance.component)
            }
            is NavigationComponent.ChildComponent.CityDetails -> {
                CityDetailsScreen(instance.component)
            }
        }
    }
}