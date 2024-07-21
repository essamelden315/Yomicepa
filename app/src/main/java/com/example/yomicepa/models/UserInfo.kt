package com.example.yomicepa.models

data class UserInfo(
    val activated: Boolean,
    val createdAt: String,
    val email: String,
    val id: Int,
    val phoneNumber: String?,
    val role: String,
    val updatedAt: String?,
    val username: String
)