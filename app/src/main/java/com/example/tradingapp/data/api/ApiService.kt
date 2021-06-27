package com.example.tradingapp.data.api

import com.example.tradingapp.model.ProducutListResponce
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @GET("ticket/count")
    susp