package com.example.yomicepa.models

data class PharmaciesLink(
    val address: String,
    val city: String,
    val pharmacyId: Int,
    val primary: Boolean,
    val state: String,
    val wholesalerId: Int,
    val zipCode: String
)