package com.example.yomicepa.models

data class LoginResponse(
    val token: String,
    val userInfo: UserInfo
)