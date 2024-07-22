package com.example.yomicepa.models

data class Content(
    val numberOfItems: Int,
    val numberOfReports: Int,
    val numberOfShipments: Int,
    val returnRequest: ReturnRequest
)