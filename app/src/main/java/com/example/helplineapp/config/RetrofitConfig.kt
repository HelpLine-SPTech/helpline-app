package com.example.myfirstproject.integracaoViaCep.config

import android.content.Context
import android.util.Log
import com.example.helplineapp.MyApp.Companion.context
import com.example.helplineapp.network.Login.LoginService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Configuração do Retrofit
object RetrofitClient{
  private const val BASE_URL = "https://helpline-api-dev.azurewebsites.net/"

  private fun provideOkHttpClient(): OkHttpClient{
    return OkHttpClient.Builder()
      .addInterceptor { chain ->
        val originalRequest = chain.request()
        val token = getToken()
        val newRequest = if (token != null){
          originalRequest.newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        } else {
          originalRequest
        }
        chain.proceed(newRequest)
        }
      .build()
  }

  private fun getToken(): String? {
    val sharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE)
    Log.d("Login", "Token: ${sharedPreferences.getString("auth_token", null)}")
    return sharedPreferences.getString("auth_token", null)
  }

  val retrofit: Retrofit by lazy{
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(provideOkHttpClient())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }
}

// Configuração do serviço
object Login {
  val apiService: LoginService by lazy {
    RetrofitClient.retrofit.create(LoginService::class.java)
  }
}