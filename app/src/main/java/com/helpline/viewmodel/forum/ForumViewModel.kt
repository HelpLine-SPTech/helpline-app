package com.helpline.viewmodel.forum

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helpline.network.forum.CommentPostResponse
import com.helpline.network.forum.ForumService
import com.helpline.network.forum.GetPostsResponse
import com.helpline.network.forum.Post
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

    fun likePost(post: Post, onSuccess: () -> Unit, onFailure: () -> Unit) {
        viewModelScope.launch {
            try {
                forumService.likePost(post.id.toString())
                onSuccess();
            } catch (e: Exception) {
                Log.d("Forum", "Error: $e")
                onFailure()
            }
        }
    }

    fun commentOnPost(postId: String, content: String, onSuccess: (CommentPostResponse) -> Unit, onFailure: (Exception) -> Unit) {
        viewModelScope.launch {
            try {
                val response = forumService.commentPost(postId, content)
                onSuccess(response)
            } catch (e: Exception) {
                onFailure(e)
            }
        }
    }
}