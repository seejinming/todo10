package com.example.tradingapp.model

data class ResponseResource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        FAILURE,
        NOINTERNET,
        DATAINSETED
    }

    companion object {

        fun <T> success(data: T): ResponseResource<T> {
            return ResponseResource(Status.SUCCESS, data, "Success")
        }

        fun <T> nointernet(message: String ): ResponseResource<T> {
            return ResponseResource(Status.NOINTERNET, null,message)
        }

        fun <T> error(message: String, data: T? = null): ResponseResource<T> {
            return ResponseResource(Status.ERROR, data, message)
        }

        fun <T> loading(data: T?): ResponseResource<T> {
            return ResponseResource(Status.LOADING, data, null)
        }

        fun <T> failed(message: String, data: T? = null): ResponseResource<T> {
            return ResponseResource(Status.FAILURE, data, message)
        }

        fun <T> dataInsert(message: String ): ResponseResource<T> {
            return ResponseResource(Status.DATAINSETED, null, message)
        }

    }


}
