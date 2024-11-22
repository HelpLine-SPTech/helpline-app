package com.helpline.viewmodel.campanha

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.campanha.Campaign
import com.helpline.network.campanha.CampaignService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CampaignViewModel(private val campaignService: CampaignService) : ViewModel() {
    private val _campaignsState = MutableStateFlow<List<Campaign>?>(null)
    val campaigns: StateFlow<List<Campaign>?> = _campaignsState

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchCampaigns() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = campaignService.getCampaigns()
                Log.d(this::class.java.name, "Campaigns: $response")
                _campaignsState.value = response.campaigns
            } catch (e: Exception) {
                // Handle error (logging, showing UI feedback, etc.)
                _campaignsState.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}