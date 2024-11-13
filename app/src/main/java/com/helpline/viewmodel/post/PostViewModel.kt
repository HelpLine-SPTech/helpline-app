package com.helpline.viewmodel.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.forum.CreatePostsResponse
import com.helpline.network.forum.ForumService
import com.helpline.network.forum.GetPostsResponse
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.HttpException
import java.lang.Exception

class PostViewModel(private val forumService: ForumService) : ViewModel() {
    fun createPost (content: String, images: List<MultipartBody.Part>, onSuccess: (CreatePostsResponse) -> Unit,
                    onFailure: (HttpException) -> Unit){
        viewModelScope.launch {
            try {
                val response = forumService.createPost(images = images, content = content , auth = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJoZWxwbGluZS1hcGkiLCJzdWIiOiJhMjA1Njg4OS1jODY3LTQ4YzQtYjAwYS0zMDMxYTBlYThjNDAiLCJleHAiOjE3MzE0NzY4MDN9.WXi8L_S3MmYQBfRz2NTGuAPmdr1ixmMF2QcrgD5M3gg")
                onSuccess(response)
            } catch (e: HttpException) {
                onFailure(e)
            }
        }
    }
}