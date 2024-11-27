package com.helpline.viewmodel.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.forum.User
import com.helpline.network.search.SearchService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class SearchViewModel(val service: SearchService) : ViewModel() {

    private val _searchResult = MutableStateFlow<List<User>>(emptyList())
    val searchResult: StateFlow<List<User>> = _searchResult

    private val _isLoading =MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun search(term: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = service.search(term)
                _searchResult.value = response.users
            } catch (e: Exception) {
                Log.e("SearchViewModel", "Error: $e")
            } finally {
                _isLoading.value = false
            }
        }
    }
}