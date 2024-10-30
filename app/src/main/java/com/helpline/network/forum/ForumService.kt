package com.helpline.network.forum

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import java.util.UUID

data class Post(
    val id: UUID,
    val content: String,
    val likes: List<Like>,
    val images: List<Image>,
    val comments: List<Comment>,
    val user: User,
    val addedAt: String,
    val liked: Boolean
)

data class Like(
    val userId: UUID
)

data class Image(
    val url: String
)

data class Comment(
    val id: UUID,
    val user: User,
    val addedAt: String,
    val content: String
)

data class User(
    val id: UUID,
    val name: String,
    val bio: String,
    val email: String,
    val document: String,
    val profilePicUrl: String,
    val type: String,
    val abilities: List<String>
)

data class GetPostsResponse(
    val posts: List<Post>,
    val success: Boolean
)

interface ForumService {
    @GET("/posts")
    suspend fun getPosts(@Header("Authorization") auth: String): GetPostsResponse
}