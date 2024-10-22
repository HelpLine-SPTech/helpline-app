package com.helpline.config

import com.helpline.viewmodel.login.LoginViewModel
import com.helpline.network.login.LoginService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
  // Definição de Retrofit
  single { provideRetrofit() }
  single { provideApiService(get()) }

  // Definição do ViewModel
  viewModel { LoginViewModel(get()) }
}

fun provideRetrofit(): Retrofit {
  return Retrofit.Builder()
    .baseUrl("https://helpline-api-dev.azurewebsites.net/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}

fun provideApiService(retrofit: Retrofit): LoginService {
  return retrofit.create(LoginService::class.java)
}
