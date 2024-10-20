package com.example.helpline.config

import com.example.helpline.ViewModel.Login.LoginViewModel
import com.example.helpline.network.Login.LoginService
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
