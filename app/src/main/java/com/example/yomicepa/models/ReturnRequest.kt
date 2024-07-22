package com.example.yomicepa.models

data class ReturnRequest(
    val createdAt: String,
    val dateDispatched: String?,
    val dateFulfilled: String?,
    val disbursements: String?,
    val id: Int,
    val pharmacy: PharmacyDetails,
    val preferredDate: String?,
    val returnRequestStatus: String,
    val returnRequestStatusLabel: String,
    val serviceFee: String?,
    val serviceType: String,
    val updatedAt: String
)