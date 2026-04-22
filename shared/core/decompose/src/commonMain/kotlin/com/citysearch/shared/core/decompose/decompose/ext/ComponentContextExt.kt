package com.citysearch.shared.core.decompose.decompose.ext

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import ru.heavycoffee.state.reducer.StateReducer

private class CoroutineScopeInstance : InstanceKeeper.Instance {
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    override fun onDestroy() {
        scope.cancel()
    }
}

private const val COMPONENT_SCOPE_KEY = "shared.core.decompose.decompose.ext.COMPONENT_SCOPE_KEY"

val AppComponentContext.componentScope: CoroutineScope
    get() = instanceKeeper.getOrCreate(key = COMPONENT_SCOPE_KEY) {
        CoroutineScopeInstance()
    }.scope

fun <ViewState, ViewEffect> AppComponentContext.reducer(
    initialState: ViewState
) = StateReducer<ViewState, ViewEffect>(
    logTag = this::class.simpleName.toString(),
    initialState = initialState,
    coroutineScope = componentScope
)