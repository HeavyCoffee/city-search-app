package com.citysearch.shared.core.usecase

import kotlin.coroutines.cancellation.CancellationException

interface UseCase<P, R> {
    suspend fun execute(params: P): R

    suspend operator fun invoke(params: P): Result<R> = try {
        Result.success(execute(params))
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.failure(e)
    }
}