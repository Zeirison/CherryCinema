package com.example.cherrycinema.data.remote.network

import retrofit2.HttpException
import java.net.SocketTimeoutException

open class ResponseHandler {

    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> Resource.error(getErrorMessage(e.code()), null)
            is SocketTimeoutException -> Resource.error(
                getErrorMessage(ErrorCodes.SocketTimeOut.code),
                null
            )
            else -> Resource.error(getErrorMessage(Int.MAX_VALUE), null)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> "Timeout"
            ErrorCodes.Unauthorized.code -> "Unauthorised"
            ErrorCodes.NotFound.code -> "Not found"
            ErrorCodes.ServiceUnavailable.code -> "Service Unavailable"
            else -> "Something went wrong"
        }
    }

    enum class ErrorCodes(val code: Int) {
        SocketTimeOut(-1),
        Unauthorized(401),
        NotFound(404),
        ServiceUnavailable(503)
    }


}