package com.helpline.viewmodel.post

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.forum.CommentPostResponse
import com.helpline.network.forum.CreatePostsResponse
import com.helpline.network.forum.ForumService
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.HttpException
import kotlin.Exception

class PostViewModel(private val forumService: ForumService) : ViewModel() {
    fun createPost (content: String, images: List<MultipartBody.Part>, onSuccess: (CreatePostsResponse) -> Unit,
                    onFailure: (HttpException) -> Unit){
        viewModelScope.launch {
            try {
                Log.d("PostCreate", "Content: $content, Images: $images")
                val response = forumService.createPost(images = images, content = content)
                onSuccess(response)
            } catch (e: HttpException) {
                onFailure(e)
            } catch (e: Exception) {
                Log.e("PostCreate", "Erro: $e")
            }
        }
    }
}