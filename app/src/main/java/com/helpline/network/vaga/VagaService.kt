package com.helpline.network.vaga

import com.helpline.network.forum.User
import retrofit2.http.GET

data class Job(
    val id: String,
    val title: String,
    val description: String,
    val abilities: List<String>?,
    val address: Address?,
    val date: String?,
    val amount: Int?,
    val subscriptions: Int?,
    val user: User?
)

data class Address(
    val id: String,
    val state: String,
    val street: String,
    val number: String,
    val complement: String?,
    val city: String,
    val zipCode: String,
    val neighborhood: String
)

data class GetVagaResponse(
    val errors: List<String>?,
    val jobs: List<Job>,
    val success: Boolean
)

interface VagaService {
    @GET("/api/jobs")
    suspend fun getAll(): GetVagaResponse
}