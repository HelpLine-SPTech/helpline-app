package com.helpline.network.campanha

import retrofit2.http.GET
import retrofit2.http.Header

import java.time.LocalDateTime
import java.util.UUID

data class GetCampaignsResponse(
    val errors: List<String>?,
    val campaigns: List<Campaign>,
    val totalPages: Int,
    val totalElements: Int,
    val success: Boolean
)

data class Campaign(
    val id: String,
    val title: String,
    val description: String,
    val ongId: String,
    val donations: List<Donation>?,
    val type: String,
    val badgeType: String,
    val monetaryGoal: Int?,
    val donationGoal: Int?
)

data class Donation(
    val id: String,
    val amount: Int,
//    val donationDate: LocalDateTime,
    val quantity: Int,
    val donorId: String,
    val campaignId: String,
    val confirmed: Boolean
)


interface CampaignService {
    @GET("/api/campaigns")
    suspend fun getCampaigns(): GetCampaignsResponse
}