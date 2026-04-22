package com.citysearch.shared.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual val Dispatchers.IO: CoroutineDispatcher
    get() = kotlinx.coroutines.Dispatchers.IO
