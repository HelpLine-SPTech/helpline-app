package com.helpline.network.perfil

import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Body
import java.util.UUID

// Data class para representar o perfil do usuário
data class Perfil(
    val id: UUID,
    val name: String,
    val bio: String,
    val email: String,
    val document: String,
    val profilePicUrl: String,
    val backgroundPicUrl: String,
    val abilities: List<String>,
    val contact: Contato
)

// Data class para representar o contato do usuário
data class Contato(
    val phone: String?,
    val instagram: String?
)

// Data class para o retorno de obter perfil
data class GetPerfilResponse(
    val perfil: Perfil,
    val success: Boolean
)

// Data class para o retorno de atualizar perfil
data class UpdatePerfilResponse(
    val success: Boolean
)

interface PerfilService {

    // Função para obter o perfil de um usuário
    @GET("/perfil/{userId}")
    suspend fun getPerfil(
        @Header("Authorization") auth: String,
        @Path("userId") userId: UUID
    ): GetPerfilResponse

    // Função para atualizar o perfil de um usuário
    @PUT("/perfil/{userId}")
    suspend fun updatePerfil(
        @Header("Authorization") auth: String,
        @Path("userId") userId: UUID,
        @Body perfil: Perfil
    ): UpdatePerfilResponse

    // Função para atualizar a foto de perfil
    @PUT("/perfil/{userId}/foto-perfil")
    suspend fun updateFotoPerfil(
        @Header("Authorization") auth: String,
        @Path("userId") userId: UUID,
        @Body fotoUrl: String
    ): UpdatePerfilResponse

    // Função para atualizar a foto de fundo
    @PUT("/perfil/{userId}/foto-fundo")
    suspend fun updatePlanoFundo(
        @Header("Authorization") auth: String,
        @Path("userId") userId: UUID,
        @Body fundoUrl: String
    ): UpdatePerfilResponse
}
