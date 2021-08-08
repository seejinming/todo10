package com.example.tradingapp.model

data class ResponseResource<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        FAILURE,
        NOINTERNET,
        DATAINSETED
 