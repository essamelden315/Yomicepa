package com.example.yomicepa.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PharmacyApiServiceInstance {
    val myApiServiceInstance: PharmacyApiService =  Retrofit.Builder().baseUrl("https://portal-test.rxmaxreturns.com/rxmax/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(PharmacyApiService::class.java)
}