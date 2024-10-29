package com.helpline.viewmodel.cadastro

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.cadastro.CadastroRequest
import com.helpline.network.cadastro.CadastroService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CadastroViewModel (private val cadastroService: CadastroService) : ViewModel() {
    fun registerUser(
        email: String,
        password: String,
        name: String,
        document: String,
        type: String,
        role: String,
        onSuccess: () -> Unit,
        onFailure: (HttpException) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val abilities = emptyList<String>()
                val request = CadastroRequest(email, password, name, document, type, role, abilities)

                val response = cadastroService.register(request)

                if (response.success) {
                    onSuccess()
                }
            } catch (e: HttpException) {
                onFailure(e)
            }
        }
    }
}