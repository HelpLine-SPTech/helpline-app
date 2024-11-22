package com.helpline.config

import android.util.Log
import com.helpline.network.cadastro.CadastroService
import com.helpline.network.campanha.CampaignService
import com.helpline.network.forum.ForumService
import com.helpline.network.login.LoginService
import com.helpline.viewmodel.cadastro.CadastroViewModel
import com.helpline.viewmodel.campanha.CampaignViewModel
import com.helpline.viewmodel.forum.ForumViewModel
import com.helpline.viewmodel.login.LoginViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
  // Definição de Retrofit
  single { Session() }
  factory { getClient(get<Session>().token) }
  single { provideRetrofit() }
  single { provideApiService(get(), get()) }
  single { provideCadastroService(get(), get())}
  single { provideForumService(get(), get())}
  single { provideCampaignService(get(), get())}

  // Definição do ViewModel
  viewModel { LoginViewModel(get(), get()) }
  viewModel { CadastroViewModel(get()) }
  viewModel { ForumViewModel(get()) }
  viewModel { CampaignViewModel(get()) }
}

fun provideRetrofit(): Retrofit {

  return Retrofit.Builder()
    .baseUrl("http://192.168.0.105:8080")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}

fun getClient(token: String): OkHttpClient {
  return OkHttpClient
    .Builder()
    .addInterceptor(InterceptorTokenJWT(token)).build()
}

fun provideApiService(retrofit: Retrofit, client: OkHttpClient): LoginService {
  return retrofit
    .newBuilder()
    .client(client)
    .build()
    .create(LoginService::class.java)
}

fun provideCadastroService(retrofit: Retrofit, client: OkHttpClient): CadastroService {
  return retrofit
    .newBuilder()
    .client(client)
    .build()
    .create(CadastroService::class.java)
}

fun provideForumService(retrofit: Retrofit, client: OkHttpClient): ForumService {
  return retrofit
    .newBuilder()
    .client(client)
    .build()
    .create(ForumService::class.java)
}

fun provideCampaignService(retrofit: Retrofit, client: OkHttpClient): CampaignService {
  return retrofit
    .newBuilder()
    .client(client)
    .build()
    .create(CampaignService::class.java)
}

/*
Classe que implementa um Interceptor para adicionar um token JWT a TODAS as requisições
 */
class InterceptorTokenJWT(val token:String): Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val currentRequest = chain.request().newBuilder()

    currentRequest.addHeader("Authorization", "Bearer $token")

    Log.d("JwtInterceptor", "Making http request to ${chain.request().url}")

    val newRequest = currentRequest.build()
    return chain.proceed(newRequest)
  }
}