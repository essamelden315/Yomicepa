package com.example.yomicepa.repository

import com.example.yomicepa.models.Item
import com.example.yomicepa.models.LoginRequest
import com.example.yomicepa.models.LoginResponse
import com.example.yomicepa.models.Pharmacy
import com.example.yomicepa.models.PharmacyListResponse
import com.example.yomicepa.models.ReturnRequest
import com.example.yomicepa.models.ReturnRequestListResponse
import com.example.yomicepa.models.Wholesaler
import com.example.yomicepa.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject


class Repository private constructor(remoteDataSource: RemoteDataSource):RepositoryInterface {
private var remote = remoteDataSource

    companion object {
        private var myInstance: Repository? = null
        fun getInstance(remote:RemoteDataSource): Repository? {
            if (myInstance==null)
                myInstance = Repository(remote)
            return myInstance
        }
    }
    override suspend fun login(loginRequest: LoginRequest): Flow<Response<LoginResponse>> {
        return remote.login(loginRequest)
    }

    override suspend fun findAllPharmacies(authHeader: String): Flow<Response<List<PharmacyListResponse>>> {
        return remote.findAllPharmacies(authHeader)
    }

    override suspend fun findPharmacyById(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<Pharmacy>> {
        return remote.findPharmacyById(pharmacyId,authHeader)
    }

    override suspend fun findAllWholesalersForPharmacyByPharmacyId(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<List<Wholesaler>>> {
        return remote.findAllWholesalersForPharmacyByPharmacyId(pharmacyId, authHeader)
    }

    override suspend fun createReturnRequest(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequest>> {
        return remote.createReturnRequest(pharmacyId,authHeader)
    }

    override suspend fun findReturnRequestById(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequest>> {
        return remote.findReturnRequestById(pharmacyId,returnRequestId,authHeader)
    }

    override suspend fun findAllReturnRequestByPharmacyId(
        pharmacyId: Int,
        authHeader: String
    ): Flow<Response<ReturnRequestListResponse>> {
        return remote.findAllReturnRequestByPharmacyId(pharmacyId,authHeader)
    }

    override suspend fun addItemToReturnRequest(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<Item>> {
        return remote.addItemToReturnRequest(pharmacyId,returnRequestId,authHeader)
    }

    override suspend fun updateItemInReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        itemId: Int,
        authHeader: String
    ): Flow<Response<Item>> {
        return remote.updateItemInReturnRequestByItemId(pharmacyId,returnRequestId,itemId,authHeader)
    }

    override suspend fun findItemInReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        itemId: Int,
        authHeader: String
    ): Flow<Response<Item>> {
        return remote.findItemInReturnRequestByItemId(pharmacyId,returnRequestId,itemId,authHeader)
    }

    override suspend fun findAllItemsInReturnRequest(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ): Flow<Response<List<Item>>> {
        return remote.findAllItemsInReturnRequest(pharmacyId,returnRequestId,authHeader)
    }

    override suspend fun deleteItemFromReturnRequestByItemId(
        pharmacyId: Int,
        returnRequestId: Int,
        authHeader: String
    ) {
        remote.deleteItemFromReturnRequestByItemId(pharmacyId,returnRequestId,authHeader)
    }
}