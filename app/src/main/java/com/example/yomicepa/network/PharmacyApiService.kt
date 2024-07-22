package com.example.yomicepa.network

import com.example.yomicepa.models.Item
import com.example.yomicepa.models.LoginRequest
import com.example.yomicepa.models.LoginResponse
import com.example.yomicepa.models.Pharmacy
import com.example.yomicepa.models.PharmacyListResponse
import com.example.yomicepa.models.ReturnRequest
import com.example.yomicepa.models.ReturnRequestListResponse
import com.example.yomicepa.models.Wholesaler
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PharmacyApiService {
    @POST("auth")
    suspend fun login(@Body loginRequest:LoginRequest): Response<LoginResponse>

    @GET("pharmacies/management")
    suspend fun findAllPharmacies(@Header("Authorization") authHeader: String): Response<List<PharmacyListResponse>>

    @GET("pharmacies/{pharmacyId}/full")
    suspend fun findPharmacyById(
        @Path("pharmacyId") pharmacyId: Int,
        @Header("Authorization") authHeader: String
    ): Response<Pharmacy>

    @GET("pharmacies/{pharmacyId}/wholesalers")
    suspend fun findAllWholesalersForPharmacyByPharmacyId(
        @Path("pharmacyId") pharmacyId: Int,
        @Header("Authorization") authHeader: String
    ):Response<List<Wholesaler>>

    @POST("pharmacies/{pharmacyId}/returnrequests")
    suspend fun createReturnRequest(
        @Path("pharmacyId") pharmacyId: Int,
        @Header("Authorization") authHeader: String
    ):Response<ReturnRequest>

    @GET("pharmacies/{pharmacyId}/returnrequests/{returnRequestId}")
    suspend fun findReturnRequestById(
        @Path("pharmacyId") pharmacyId: Int,
        @Path("returnRequestId") returnRequestId: Int,
        @Header("Authorization") authHeader: String
    ):Response<ReturnRequest>

    @GET("pharmacies/{pharmacyId}/returnrequests")
    suspend fun findAllReturnRequestByPharmacyId(
        @Path("pharmacyId") pharmacyId: Int,
        @Header("Authorization") authHeader: String
    ):Response<ReturnRequestListResponse>

    @POST("pharmacies/{pharmacyId}/returnrequests/{returnRequestId}/items")
    suspend fun addItemToReturnRequest(
        @Path("pharmacyId") pharmacyId: Int,
        @Path("returnRequestId") returnRequestId: Int,
        @Header("Authorization") authHeader: String
    ):Response<Item>

    @PUT("pharmacies/{pharmacyId}/returnrequests/{returnRequestId}/items/{itemId}")
    suspend fun updateItemInReturnRequestByItemId(
        @Path("pharmacyId") pharmacyId: Int,
        @Path("returnRequestId") returnRequestId: Int,
        @Path("itemId") itemId: Int,
        @Header("Authorization") authHeader: String
    ):Response<Item>

    @GET("pharmacies/{pharmacyId}/returnrequests/{returnRequestId}/items/{itemId}")
    suspend fun findItemInReturnRequestByItemId(
        @Path("pharmacyId") pharmacyId: Int,
        @Path("returnRequestId") returnRequestId: Int,
        @Path("itemId") itemId: Int,
        @Header("Authorization") authHeader: String
    ):Response<Item>

    @GET("pharmacies/{pharmacyId}/returnrequests/{returnRequestId}/items")
    suspend fun findAllItemsInReturnRequest(
        @Path("pharmacyId") pharmacyId: Int,
        @Path("returnRequestId") returnRequestId: Int,
        @Header("Authorization") authHeader: String
    ):Response<List<Item>>

    @DELETE("pharmacies/{pharmacyId}/returnrequests/{returnRequestId}/items/{itemId}")
    suspend fun deleteItemFromReturnRequestByItemId(
        @Path("pharmacyId") pharmacyId: Int,
        @Path("returnRequestId") returnRequestId: Int,
        @Header("Authorization") authHeader: String
    )



}