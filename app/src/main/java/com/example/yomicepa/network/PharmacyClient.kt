package com.example.yomicepa.network

import com.example.yomicepa.models.Item
import com.example.yomicepa.models.LoginRequest
import com.example.yomicepa.models.LoginResponse
import com.example.yomicepa.models.Pharmacy
import com.example.yomicepa.models.PharmacyListResponse
import com.example.yomicepa.models.ReturnRequest
import com.example.yomicepa.models.ReturnRequestListResponse
import com.example.yomicepa.models.Wholesaler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class PharmacyClient :RemoteDataSource {
    private val remote = PharmacyApiServiceInstance.myApiServiceInstance
    companion object {
        private var myInstance: PharmacyClient? = null
        fun getInstance(): PharmacyClient? {
            if (myInstance==null)
                myInstance = PharmacyClient()
            return myInstance
        }
    }
    override suspend fun login(loginRequest : LoginRequest): Flow<Response<LoginResponse>> {
        return flow{emit(remote.login(loginRequest)) }
    }

    override suspend fun findAllPharmacies(authHeader: String): Flow<Response<List<PharmacyListResponse>>> {
        return flow{emit(remote.findAllPharmacies(authHeader)) }
    }

    override suspend fun findPharmacyById(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<Pharmacy>> {
        return flow{emit(remote.findPharmacyById(pharmacyId,authHeader)) }
    }

    override suspend fun findAllWholesalersForPharmacyByPharmacyId(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<List<Wholesaler>>> {
        return flow{emit(remote.findAllWholesalersForPharmacyByPharmacyId(pharmacyId, authHeader)) }
    }

    override suspend fun createReturnRequest(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequest>> {
        return flow{emit(remote.createReturnRequest(pharmacyId,authHeader)) }
    }

    override suspend fun findReturnRequestById(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequest>> {
        return flow{emit(remote.findReturnRequestById(pharmacyId,returnRequestId,authHeader)) }
    }

    override suspend fun findAllReturnRequestByPharmacyId(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequestListResponse>> {
        return flow{emit(remote.findAllReturnRequestByPharmacyId(pharmacyId,authHeader)) }
    }

    override suspend fun addItemToReturnRequest(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<Item>> {
        return flow{emit(remote.addItemToReturnRequest(pharmacyId,returnRequestId,authHeader)) }
    }

    override suspend fun updateItemInReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        itemId: Int,
        authHeader: String
    ): Flow<Response<Item>> {
        return flow{emit(remote.updateItemInReturnRequestByItemId(pharmacyId,returnRequestId,itemId,authHeader)) }
    }

    override suspend fun findItemInReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        itemId: Int,
        authHeader: String
    ): Flow<Response<Item>> {
        return flow{emit(remote.findItemInReturnRequestByItemId(pharmacyId,returnRequestId,itemId,authHeader)) }
    }

    override suspend fun findAllItemsInReturnRequest(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<List<Item>>> {
        return flow{emit(remote.findAllItemsInReturnRequest(pharmacyId,returnRequestId,authHeader)) }
    }

    override suspend fun deleteItemFromReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ) {
        remote.deleteItemFromReturnRequestByItemId(pharmacyId,returnRequestId,authHeader)
    }
}