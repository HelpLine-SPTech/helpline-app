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
                val response = vagaService.getVagaPorId("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJoZWxwbGluZS1hcGkiLCJzdWIiOiJhMjA1Njg4OS1jODY3LTQ4YzQtYjAwYS0zMDMxYTBlYThjNDAiLCJleHAiOjE3MzE1NjAwNDh9.i2XmygTNaED5RvmS11jepnMmF62uTxGK9MIoW47L6A4")
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