package com.citysearch.shared.core.network

import android.util.Log
import io.ktor.client.plugins.logging.Logger

internal actual fun Logger(): Logger = object : Logger {
    override fun log(message: String) {
        Log.d("Ktor", message)
    }
}