package com.example.helplineapp.ViewModel.Login

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helplineapp.MyApp.Companion.context
import com.example.helplineapp.network.Login.LoginService
import com.example.myfirstproject.integracaoViaCep.config.Login
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

  var userEmail: String by mutableStateOf("ong@gmail.com")
  var userPassword: String by mutableStateOf("aditum123")


  fun loginUser(onLoginSuccess: () -> Unit, onLoginError: (String) -> Unit){
    viewModelScope.launch {
      try {
        val response = userLogin(userEmail, userPassword)
        Log.d("Login", "Token: ${response.token}")
        onLoginSuccess()
      } catch (e: Exception) {
        Log.e("Login", "Erro ao fazer login", e)
        onLoginError("Usu[ario ou senha incorretos!")
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

  fun onEmailChange(it: String) {
    userEmail = it
  }

  fun onPasswordChange(it: String) {
    userPassword = it
  }

}
