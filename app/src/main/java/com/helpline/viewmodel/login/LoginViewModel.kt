package com.example.helpline.ViewModel.Login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.helpline.network.Login.LoginRequest
import com.example.helpline.network.Login.LoginService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel (private val loginService: LoginService) : ViewModel() {

  var loginToken: String? = null
    private set

  var errorMessage: String? = null
    private set

  fun loginUser(email: String, password: String, onLoginSuccess: () -> Unit,
            onLoginError: () -> Unit ) {
    viewModelScope.launch {
      try {
        val response = loginService.login(LoginRequest(email, password))
        if (response != null) {
          loginToken = response.token
          errorMessage = null // Clear any previous error
          onLoginSuccess()
        } else {
          onLoginError()
          errorMessage = "Invalid username or password"
        }

      } catch (e: HttpException){
        onLoginError()
        errorMessage = "Invalid username or password"
      }
    }
  }
}
