package com.helpline.network.perfil

import com.helpline.network.forum.User
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Body
import java.util.UUID

// Data class para representar o contato do usuário
data class Contato(
    val phone: String?,
    val instagram: String?
)

// Data class para o retorno de obter perfil
data class GetPerfilResponse(
    val user: User,
    val success: Boolean
)

// Data class para o retorno de atualizar perfil
data class UpdatePerfilResponse(
    val success: Boolean
)

interface PerfilService {

    // Função para obter o perfil de um usuário
    @GET("/auth/{userId}")
    suspend fun getPerfil(
        @Header("Authorization") auth: String,
        @Path("userId") userId: UUID
    ): GetPerfilResponse

    // Função para atualizar o perfil de um usuário
    @PUT("/auth/{userId}")
    suspend fun updatePerfil(
        @Header("Authorization") auth: String,
        @Path("userId") userId: UUID,
        @Body user: User
    ): UpdatePerfilResponse

}
