package com.helpline.viewmodel.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.config.Session
import com.helpline.network.login.LoginRequest
import com.helpline.network.login.LoginService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginViewModel(
    private val loginService: LoginService,
    private val session: Session
) : ViewModel() {


    fun loginUser(
        email: String, password: String, onLoginSuccess: () -> Unit,
        onLoginError: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                Log.d("LOGIN", "Logging user with email: $email")
                val response = loginService.login(LoginRequest(email, password))
                if (response != null) {
                    session.token = response.token
                    session.loggedUser = response.user
                    onLoginSuccess()
                } else {
                    onLoginError()
                }

            } catch (e: HttpException) {
                Log.d("Login View Model", e.message())
                onLoginError()
            } catch (e: Exception) {
                e.message?.let { Log.d("Login View Model", it) }
                onLoginError()
            }
        }
    }
}
