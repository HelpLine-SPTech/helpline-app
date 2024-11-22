package com.helpline.network.login

import com.helpline.network.forum.User
import retrofit2.http.Body
import retrofit2.http.POST

// interface que define como a API deve se comportar
// e quais endpoints ela terá

  data class LoginRequest(val email: String, val password: String)
  data class LoginResponse(val token: String, val user: User)

interface LoginService {

  @POST("/api/auth/login") // Verbo HTTP que será usado

  // Função que faz a requisição para a API
  suspend fun login(@Body request: LoginRequest): LoginResponse

}