package com.example.yomicepa.models

data class PharmacyListResponse(
    val doingBusinessAs: String,
    val enabled: Boolean,
    val numberOfReturns: Int,
    val pharmacyId: Int
)