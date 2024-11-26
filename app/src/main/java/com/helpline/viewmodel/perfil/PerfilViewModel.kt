package com.helpline.viewmodel.perfil

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.forum.User
import com.helpline.network.perfil.PerfilService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.UUID

class PerfilViewModel(private val perfilService: PerfilService) : ViewModel() {

    private val _perfilData = MutableStateFlow<User?>(null)
    val perfilData: StateFlow<User?> get() = _perfilData

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    fun fetchPerfilData(userId: UUID, authToken: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val perfilResponse = perfilService.getPerfil(authToken, userId)
                Log.d("PerfilViewModel", "Perfil response: $perfilResponse")
                if (perfilResponse.success) {
                    _perfilData.value = perfilResponse.user
                } else {
                    _errorMessage.value = "Failed to fetch profile."
                }
            } catch (e: Exception) {
                Log.d("PerfilViewModel", "Perfil response: $e")
                _errorMessage.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }

    fun updatePerfil(userId: UUID, authToken: String, user: User) {
        viewModelScope.launch {
            _loading.value = true

            try {

                val updateResponse = perfilService.updatePerfil(authToken, userId, user)

                if (updateResponse.success) {
                    _perfilData.value = user
                } else {
                    _errorMessage.value = "Failed to update profile."
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}
