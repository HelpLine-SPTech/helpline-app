package com.helpline.viewmodel.vaga

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.vaga.GetVagaResponse
import com.helpline.network.vaga.VagaService
import kotlinx.coroutines.launch
import java.lang.Exception

class VagaViewModel (private val vagaService: VagaService) : ViewModel() {
    fun getVagaPorId(onSuccess: (GetVagaResponse) -> Unit, onFailure: (Exception) -> Unit){
        viewModelScope.launch{
            try {
                val response = vagaService.getAll()
                if (response.success){
                    onSuccess(response)
                }
            } catch (e: Exception) {
                Log.d("VAGAS RESPOSTA", e.toString())
                onFailure(e)
            }
        }
    }
}