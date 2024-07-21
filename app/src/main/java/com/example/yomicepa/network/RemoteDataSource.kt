package com.example.yomicepa.network

import com.example.yomicepa.models.LoginResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteDataSource {
    suspend fun login(username:String , password:String): Flow<Response<LoginResponse>>
}