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
import com.example.helplineapp.network.Login.LoginService
import com.example.helplineapp.config.Login
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

  var userEmail: String by mutableStateOf("")
  var userPassword: String by mutableStateOf("")


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

 // Função para guardar o token
  private fun saveToken(token: String) {
    // Salvar o token utilizando SharedPreferences
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("login_token", Context.MODE_PRIVATE)
    sharedPreferences.edit().putString("auth_token", token).apply()
   Log.d("Token no SharedPreferences", "${sharedPreferences.getString("login_token", null)}")
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
