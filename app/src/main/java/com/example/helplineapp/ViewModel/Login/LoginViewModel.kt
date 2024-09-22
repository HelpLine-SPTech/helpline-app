package com.example.helplineapp.ViewModel.Login

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helplineapp.network.Login.LoginRequest
import com.example.helplineapp.network.Login.LoginService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class LoginState{
  data object Loading : LoginState()
  data class Success(val token: String) : LoginState()
  data class Error(val message: String) : LoginState()
}

class LoginViewModel (private val loginService: LoginService) : ViewModel() {

  // Usar StateFlow para que o estado possa ser observado
  private val _loginState = MutableStateFlow<LoginState>(LoginState.Loading)
  val loginState: StateFlow<LoginState> = _loginState


  fun loginUser(email: String, password: String) {
    viewModelScope.launch{
      _loginState.value = LoginState.Loading
      try {
        val response = loginService.login(LoginRequest(email, password))
        if (response.isSuccessful){
          response.body()?.let{
            _loginState.value = LoginState.Success(it.token)
          } ?: run{
            _loginState.value = LoginState.Error("Erro ao fazer login")
          }
        }
      } catch (e: Exception){
        _loginState.value = LoginState.Error(e.localizedMessage ?: "Erro ao fazer login")
      }
    }
  }
}
