package com.example.myfirstproject.integracaoViaCep.config

import com.example.myfirstproject.integracaoViaCep.Interface.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Configuração do Retrofit
object RetrofitClientLogin{
  private const val BASE_URL = "https://helpline-api-dev.azurewebsites.net/"
  val retrofit: Retrofit by lazy{
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }
}

// Configuração do serviço
object LoginClient {
  val apiService: LoginService by lazy {
    RetrofitClientLogin.retrofit.create(LoginService::class.java)
  }
}