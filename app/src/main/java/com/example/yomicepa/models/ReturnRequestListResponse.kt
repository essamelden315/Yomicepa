package com.example.yomicepa.models

data class ReturnRequestListResponse(
    val content: List<Content>,
    val empty: Boolean,
    val numberOfElements: Int,
    val size: Int,
)