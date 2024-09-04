package com.example.helplineapp.ViewModel.Login

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helplineapp.GetContext.Companion.context
import com.example.myfirstproject.integracaoViaCep.Interface.LoginService
import com.example.myfirstproject.integracaoViaCep.config.LoginClient
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

  var userEmail: String by mutableStateOf("ong@gmail.com")
  var userPassword: String by mutableStateOf("aditum123")


  fun loginUser(onLoginSuccess: () -> Unit, onLoginError: (String) -> Unit){
    viewModelScope.launch {
      try {
        val response = userLogin(userEmail, userPassword)
        Log.d("LoginViewModel", "Token: ${response.token}")
        saveToken(response.token)
        Log.d("LoginViewModel", "Token salvo com sucesso!")
        onLoginSuccess()
      } catch (e: Exception) {
        Log.e("LoginViewModel", "Erro ao fazer login", e)
        onLoginError("Usuário ou senha incorretos!")
      }
    }
  }

  private suspend fun userLogin(email: String, password: String): LoginService.LoginResponse{
    val loginRequest = LoginService.LoginRequest(email, password)
    saveToken(loginRequest.toString())
    Log.d("Login", "Token: ${loginRequest.toString()}")
    return Login.apiService.login(loginRequest)
  }

  private fun saveToken(token: String){
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE)
    sharedPreferences.edit().putString("auth_token", token).apply()
  }

  fun getToken(): String?{
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("login", Context.MODE_PRIVATE)
    return sharedPreferences.getString("auth_token", null)
  }

  // Função para guardar o token
  private fun saveToken(token: String) {
    // Salvar o token em algum lugar, como SharedPreferences ou DataStore
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE)
    sharedPreferences.edit().putString("auth_token", token).apply()
  }

  fun getToken(): String?{
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE)
    return sharedPreferences.getString("auth_token", null)
  }


  fun onEmailChange(it: String) {
    userEmail = it
  }

  fun onPasswordChange(it: String) {
    userPassword = it
  }

}
