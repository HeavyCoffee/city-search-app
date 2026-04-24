package com.citysearch.shared.feature.navigation.impl.presentation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import com.citysearch.shared.core.decompose.decompose.AppComponentContext
import com.citysearch.shared.feature.citydetails.presentation.CityDetailsComponent
import com.citysearch.shared.feature.citydetails.presentation.model.CityDetails
import com.citysearch.shared.feature.list.domain.model.City
import com.citysearch.shared.feature.navigation.presentation.BottomNavigationComponent
import com.citysearch.shared.feature.navigation.presentation.NavigationComponent
import com.citysearch.shared.feature.navigation.presentation.NavigationComponent.ChildComponent
import com.citysearch.shared.feature.navigation.presentation.NavigationComponent.ChildConfig
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf

@Factory(binds = [NavigationComponent::class])
internal class NavigationComponentImpl(
    @InjectedParam appComponentContext: AppComponentContext
) : NavigationComponent, AppComponentContext by appComponentContext, KoinComponent {
    private val navigation = StackNavigation<ChildConfig>()
    override val stack: Value<ChildStack<*, ChildComponent>> = childStack(
        source = navigation,
        serializer = ChildConfig.serializer(),
        initialConfiguration = ChildConfig.BottomNavigation,
        childFactory = ::componentFactory
    )

    private fun componentFactory(
        config: ChildConfig,
        appComponentContext: AppComponentContext
    ): ChildComponent = when (config) {
        ChildConfig.BottomNavigation -> ChildComponent.BottomNavigation(
            getBottomNavigationComponent(
                appComponentContext = appComponentContext,
                onCitySelected = {
                    navigation.pushNew(ChildConfig.CityDetails(it))
                }
            )
        )
        is ChildConfig.CityDetails -> ChildComponent.CityDetails(
            getCityDetailsComponent(
                appComponentContext = appComponentContext,
                city = config.city,
                onBackClicked = { navigation.pop() }
            )
        )
    }

    private fun getBottomNavigationComponent(
        appComponentContext: AppComponentContext,
        onCitySelected: (City) -> Unit
    ): BottomNavigationComponent = get {
        parametersOf(appComponentContext, onCitySelected)
    }

    private fun getCityDetailsComponent(
        appComponentContext: AppComponentContext,
        city: City,
        onBackClicked: () -> Unit
    ): CityDetailsComponent = get {
        parametersOf(
            appComponentContext,
            CityDetails(
                name = city.name,
                country = city.country,
                population = city.pop
            ),
            onBackClicked
        )
    }
}