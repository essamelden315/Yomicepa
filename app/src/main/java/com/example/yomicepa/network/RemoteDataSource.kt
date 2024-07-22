package com.example.yomicepa.network

import com.example.yomicepa.models.Item
import com.example.yomicepa.models.LoginResponse
import com.example.yomicepa.models.Pharmacy
import com.example.yomicepa.models.PharmacyListResponse
import com.example.yomicepa.models.ReturnRequest
import com.example.yomicepa.models.ReturnRequestListResponse
import com.example.yomicepa.models.Wholesaler
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteDataSource {
    suspend fun login(username: String, password: String): Flow<Response<LoginResponse>>

    suspend fun findAllPharmacies(authHeader: String): Flow<Response<List<PharmacyListResponse>>>

    suspend fun findPharmacyById(pharmacyId: Int, authHeader: String): Flow<Response<Pharmacy>>

    suspend fun findAllWholesalersForPharmacyByPharmacyId(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<List<Wholesaler>>>

    suspend fun createReturnRequest(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequest>>

    suspend fun findReturnRequestById(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequest>>


    suspend fun findAllReturnRequestByPharmacyId(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequestListResponse>>


    suspend fun addItemToReturnRequest(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<Item>>

    suspend fun updateItemInReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        itemId: Int,
        authHeader: String
    ): Flow<Response<Item>>

    suspend fun findItemInReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        itemId: Int,
        authHeader: String
    ): Flow<Response<Item>>

    suspend fun findAllItemsInReturnRequest(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<List<Item>>>

    suspend fun deleteItemFromReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    )
}