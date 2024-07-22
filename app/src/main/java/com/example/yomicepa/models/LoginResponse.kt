package com.example.yomicepa.models

data class LoginResponse(
    var token: String?,
    var userInfo: User?
)