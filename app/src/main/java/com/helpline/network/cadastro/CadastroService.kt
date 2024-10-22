package com.example.helpline.network.Cadastro

import retrofit2.http.Body
import retrofit2.http.POST

data class CadastroRequest(
    val email: String,
    val password: String,
    val name: String,
    val document: String,
    val type: String = "COMMON",
    val role: String = "ADMIN",
    val abilities: List<String>
)

data class CadastroResponse(
    val errors: List<String>,
    val savedUser: SavedUser,
    val success: Boolean
)

data class SavedUser(
    val id: String,
    val addedAt: String,
    val email: String,
    val password: String,
    val name: String,
    val bio: String,
    val document: String,
    val profilePicUrl: String,
    val role: String,
    val enabled: Boolean,
    val username: String,
)


interface CadastroService {
    @POST("/auth/register")
    suspend fun register(@Body body: CadastroRequest) : CadastroResponse
}