package com.example.cherrycinema.data.remote.network

data class Resource<out T>(val status: Status, val response: T?, val msg: String?) {
    companion object {
        fun <T> success(response: T): Resource<T> {
            return Resource(Status.SUCCESS, response, null)
        }

        fun <T> error(msg: String, response: T? = null): Resource<T> {
            return Resource(Status.ERROR, response, msg)
        }
    }
}