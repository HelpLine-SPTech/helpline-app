package com.helpline.viewmodel.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.config.TokenManager
import com.helpline.network.login.LoginRequest
import com.helpline.network.login.LoginService
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel (private val loginService: LoginService) : ViewModel() {
  fun loginUser(email: String, password: String, onLoginSuccess: () -> Unit,
            onLoginError: () -> Unit ) {
    viewModelScope.launch {
      try {
//        val tokenHandler = TokenManager(context)

        val response = loginService.login(LoginRequest(email, password))
        if (response != null) {
//          tokenHandler.saveToken(response.token)
          onLoginSuccess()
        } else {
          onLoginError()
        }

      } catch (e: HttpException){
        Log.d("Login View Model", e.message())
        onLoginError()
      }
    }
  }
}
