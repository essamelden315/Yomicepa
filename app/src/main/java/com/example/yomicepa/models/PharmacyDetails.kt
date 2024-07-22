package com.example.yomicepa.models

data class PharmacyDetails(
    val companyType: String,
    val createdAt: String?,
    val dea: String,
    val directDepositInfo: String?,
    val doingBusinessAs: String,
    val enabled: Boolean,
    val id: Int,
    val legalBusinessName: String,
    val licenseState: String,
    val licenseStateCode: String,
    val npi: String,
    val reimbursementType: String,
    val updatedAt: String?,
    val user: User,
    val wholesalersLinks: List<WholesalersLink>
)