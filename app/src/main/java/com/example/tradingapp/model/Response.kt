
package com.example.tradingapp.model

data class Response(
    val ask: Double,
    val bit: Double,
    val c: Boolean,
    val date: String,
    val product_id: Int,
    val product_name: String,
    val timestamp: Int
)