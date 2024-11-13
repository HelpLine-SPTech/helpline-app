package com.helpline.config

import android.content.Context
import com.helpline.network.cadastro.CadastroService
import com.helpline.network.forum.ForumService
import com.helpline.viewmodel.login.LoginViewModel
import com.helpline.network.login.LoginService
import com.helpline.viewmodel.cadastro.CadastroViewModel
import com.helpline.viewmodel.forum.ForumViewModel
import com.helpline.viewmodel.post.PostViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
  // Definição de Retrofit
  single { provideRetrofit() }
  single { provideApiService(get()) }
  single { provideCadastroService(get())}
  single { provideForumService(get())}

  // Definição do ViewModel
  viewModel { LoginViewModel(get(), androidContext()) }
  viewModel { CadastroViewModel(get()) }
  viewModel { ForumViewModel(get()) }
  viewModel { PostViewModel(get()) }
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

fun provideCadastroService(retrofit: Retrofit): CadastroService {
  return retrofit.create(CadastroService::class.java)
}

fun provideForumService(retrofit: Retrofit): ForumService {
  return retrofit.create(ForumService::class.java)
}



