package com.example.tradingapp.data.api

import com.example.tradingapp.model.ProducutListResponce
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @GET("ticket/count")
    suspend fun getCount(
        @Query("date")request: String,
        @Query ("todate")toDateRequest: String
    ): Response<ProducutListResponce>

    @GET("apis/randomNumber.php")
    suspend fun getProductDetaills(): Response<ProducutListResponce>

    @POST("ticket/getByassignlist")
    suspend fun getAssignListData(
        @Header("X-Authorization") loginAuthToken:String?,
        @Body requestBody: RequestBody
    ): Response<ProducutListResponce>



}