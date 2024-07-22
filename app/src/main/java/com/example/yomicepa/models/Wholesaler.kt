package com.example.yomicepa.models

data class Wholesaler(
    val accountNumber: String?,
    val id: Int,
    val name: String,
    val pharmaciesLinks: List<PharmaciesLink>
)