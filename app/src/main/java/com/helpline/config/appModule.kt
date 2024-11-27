package com.helpline.config

import android.util.Log
import com.helpline.network.cadastro.CadastroService
import com.helpline.network.campanha.CampaignService
import com.helpline.network.forum.ForumService
import com.helpline.viewmodel.login.LoginViewModel
import com.helpline.network.login.LoginService
import com.helpline.network.search.SearchService
import com.helpline.network.perfil.PerfilService
import com.helpline.network.vaga.VagaService
import com.helpline.viewmodel.cadastro.CadastroViewModel
import com.helpline.viewmodel.campanha.CampaignViewModel
import com.helpline.viewmodel.forum.ForumViewModel
import com.helpline.viewmodel.search.SearchViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import com.helpline.viewmodel.perfil.PerfilViewModel
import com.helpline.viewmodel.post.PostViewModel
import com.helpline.viewmodel.vaga.VagaViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit


val appModule = module {
  // Definição de Retrofit
  single { Session() }
  factory { getClient(get<Session>().token) }
  single { provideRetrofit() }
  single { provideApiService(get(), get()) }
  single { provideCadastroService(get(), get())}
  single { provideForumService(get(), get())}
  single { provideCampaignService(get(), get())}
  single { provideSearchService(get(), get())}
  single { providePerfilService(get(), get())}
  single { provideVagaService(get(), get())}

  // Definição do ViewModel
  viewModel { LoginViewModel(get(), get()) }
  viewModel { CadastroViewModel(get()) }
  viewModel { ForumViewModel(get()) }
  viewModel { CampaignViewModel(get()) }
  viewModel { SearchViewModel(get())}
  viewModel { PostViewModel(get()) }
  viewModel { PerfilViewModel(get()) }
  viewModel { VagaViewModel(get()) }
}

fun provideRetrofit(): Retrofit {
  return Retrofit.Builder()
    .baseUrl("https://helpline-api-gzb4d6ahg7hpcygx.brazilsouth-01.azurewebsites.net")
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}


fun getClient(token: String): OkHttpClient {
  return OkHttpClient
    .Builder()
    .connectTimeout(10, TimeUnit.MINUTES)
    .writeTimeout(10, TimeUnit.MINUTES)
    .readTimeout(10, TimeUnit.MINUTES)
    .callTimeout(10, TimeUnit.MINUTES)
    .addInterceptor(LoggingInterceptor())
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

fun provideSearchService(retrofit: Retrofit, client: OkHttpClient): SearchService {
  return retrofit
    .newBuilder()
    .client(client)
    .build()
    .create(SearchService::class.java)
}

fun providePerfilService(retrofit: Retrofit, client: OkHttpClient): PerfilService {
    return retrofit
        .newBuilder()
        .client(client)
        .build()
        .create(PerfilService::class.java)
}

fun provideVagaService(retrofit: Retrofit, client: OkHttpClient): VagaService {
    return retrofit
        .newBuilder()
        .client(client)
        .build()
        .create(VagaService::class.java)
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

internal class LoggingInterceptor : Interceptor {
  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()

    val t1 = System.nanoTime()
    Log.i("Logging interceptor", "Sending request ${request.url} on ${chain.connection()}\n${request.headers}")

    val response: Response = chain.proceed(request)

    val t2 = System.nanoTime()
    Log.i("Logging interceptor", "Received response for ${response.request.url} in ${String.format("%.1f", (t2 - t1) / 1e6)}ms\n${response.headers}")

    return response
  }
}