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
                val response = forumService.getPosts()
                onSuccess(response)
            } catch (e: Exception) {
                onFailure(e)
            }
        }
    }
}