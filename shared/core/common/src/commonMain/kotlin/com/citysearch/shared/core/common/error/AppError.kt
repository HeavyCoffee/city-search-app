package com.citysearch.shared.core.common.error

sealed class AppException(
    msg: String? = null,
    cause: Throwable? = null
) : Throwable(msg, cause) {
    class ConnectionException(msg: String?, cause: Throwable?) : AppException(msg, cause)
    class GeneralException(msg: String?, cause: Throwable?) : AppException(msg, cause)
    abstract class BusinessLogicException(msg: String?, cause: Throwable?) : AppException(msg, cause)
}