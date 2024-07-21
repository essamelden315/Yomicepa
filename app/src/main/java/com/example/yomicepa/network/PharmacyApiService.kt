package com.example.yomicepa.network

import com.example.yomicepa.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PharmacyApiService {
    @POST("/auth")
    suspend fun login(@Body username: String,@Body password: String): Response<LoginResponse>
}