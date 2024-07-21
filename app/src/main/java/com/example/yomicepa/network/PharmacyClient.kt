package com.example.yomicepa.network

import com.example.yomicepa.models.LoginResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class PharmacyClient(private val remote:PharmacyApiService):RemoteDataSource {

    override suspend fun login(username: String, password: String): Flow<Response<LoginResponse>> {
        return flow{emit(remote.login(username,password)) }
    }
}