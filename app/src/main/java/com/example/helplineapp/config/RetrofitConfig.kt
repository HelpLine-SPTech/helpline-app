package com.example.myfirstproject.integracaoViaCep.config

import android.content.Context
import android.util.Log
import com.example.helplineapp.GetContext.Companion.context
import com.example.myfirstproject.integracaoViaCep.Interface.LoginService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Configuração do Retrofit
object RetrofitClientLogin{
  private const val BASE_URL = "https://helpline-api-dev.azurewebsites.net/"

  private fun provideOkHttpClient(context: Context): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor { chain: Interceptor.Chain ->
        val requestBuilder: Request.Builder = chain.request().newBuilder()

        // Recupera o token do SharedPreferences
        val sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("auth_token", null)

        // Se o token não for nulo, adicione-o ao cabeçalho da requisição
        if (token != null) {
          requestBuilder.addHeader("Authorization", "Bearer $token")
        }

        chain.proceed(requestBuilder.build())
      }
      .build()
  }

  val retrofit: Retrofit by lazy{
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(provideOkHttpClient(context))
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