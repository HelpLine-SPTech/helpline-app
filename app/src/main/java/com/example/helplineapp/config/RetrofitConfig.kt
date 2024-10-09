package com.example.helplineapp.config

import android.util.Log
import com.example.helplineapp.GetContext.Companion.context
import com.example.helplineapp.network.Login.LoginService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Configuração do Retrofit
object RetrofitClient {
  private const val BASE_URL = "https://helpline-api-dev.azurewebsites.net/"

//  private fun provideOkHttpClient(context: Context): OkHttpClient {
//    return OkHttpClient.Builder()
//      .addInterceptor { chain: Interceptor.Chain ->
//        val originalRequest = chain.request()
//
//        // Verifica se a requisição é de login ou se o token está ausente
//        if (originalRequest.url.encodedPath.contains("/login") ||
//          originalRequest.url.encodedPath.contains("/register")) {
//          // Não adiciona o cabeçalho Authorization para login ou registro
//          return@addInterceptor chain.proceed(originalRequest)
//        }
//
//        // Recupera o token do SharedPreferences
//        val sharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE)
//        val token = sharedPreferences.getString("auth_token", null)
//
//        // Constrói uma nova requisição com o cabeçalho de autenticação, se o token não for nulo
//        val request = if (token != null) {
//          originalRequest.newBuilder()
//            .addHeader("Authorization", "Bearer $token")
//            .build()
//        } else {
//          originalRequest
//        }
//
//        // Logando os headers da requisição
//        Log.d("HTTP Request", "URL: ${request.url}")
//        Log.d("HTTP Request", "Headers: ${request.headers}")
//
//        // Enviando a requisição e capturando a resposta
//        val response = chain.proceed(request)
//
//        // Logando o corpo da resposta
//        val responseBody = response.body?.string()
//        Log.d("HTTP Response", "Body: $responseBody")
//
//        // Retornando a resposta original com o corpo recriado
//        response.newBuilder()
//          .body((responseBody ?: "").toResponseBody(response.body?.contentType()))
//          .build()
//      }
//      .build()
//  }

  val retrofit: Retrofit by lazy {
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      //.client(provideOkHttpClient(context))
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