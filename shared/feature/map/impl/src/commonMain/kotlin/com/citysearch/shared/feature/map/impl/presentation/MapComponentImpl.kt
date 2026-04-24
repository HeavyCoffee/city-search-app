package com.citysearch.shared.feature.map.impl.presentation

import com.citysearch.shared.core.decompose.decompose.AppComponentContext
import com.citysearch.shared.feature.map.presentation.MapComponent
import com.citysearch.shared.feature.map.presentation.MapComponent.*
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam
import org.orbitmvi.orbit.Container

@Factory(binds = [MapComponent::class])
class MapComponentImpl(
    @InjectedParam componentContext: AppComponentContext,
) : MapComponent, AppComponentContext by componentContext {
    override val container: Container<State, Effect>
        get() = TODO("Not yet implemented")
}