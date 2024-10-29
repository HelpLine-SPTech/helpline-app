package com.helpline.viewmodel.forum

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.forum.ForumService
import com.helpline.network.forum.GetPostsResponse
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.lang.Exception

class ForumViewModel(private val forumService: ForumService) : ViewModel() {
    fun getPosts(onSuccess: (GetPostsResponse) -> Unit, onFailure: (Exception) -> Unit) {
        viewModelScope.launch {
            try {
                val response = forumService.getPosts("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJoZWxwbGluZS1hcGkiLCJzdWIiOiJkMTU3NmNjMy0wMGVhLTRkZGUtOGRlZC1lNGUzYzY1NTQ4NDIiLCJleHAiOjE3MzAxNzMzMzl9.wE-xr1WxUWYk8yY6VVyTNXkg3BkWPeaqeEN0il-EcOs")
                onSuccess(response)
            } catch (e: Exception) {
                onFailure(e)
            }
        }
    }
}