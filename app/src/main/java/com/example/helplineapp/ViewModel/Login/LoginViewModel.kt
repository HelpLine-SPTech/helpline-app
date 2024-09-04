package com.example.helplineapp.ViewModel.Login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstproject.integracaoViaCep.Interface.LoginService
import com.example.myfirstproject.integracaoViaCep.config.LoginClient
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

  var userEmail: String by mutableStateOf("")
  var userPassword: String by mutableStateOf("")


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
    return LoginClient.apiService.login(loginRequest)
  }

  fun onEmailChange(it: String) {
    userEmail = it
  }

  fun onPasswordChange(it: String) {
    userPassword = it
  }

}
