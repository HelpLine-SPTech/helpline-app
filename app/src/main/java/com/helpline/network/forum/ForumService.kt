package com.helpline.network.forum

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import java.time.LocalDateTime
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.UUID

data class Post(
    val id: UUID,
    val content: String,
    val likes: List<Like>,
    val images: List<Image>,
    var comments: MutableList<Comment>,
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
    val bio: String?,
    val email: String,
    val document: String,
    val profilePicUrl: String?,
    val type: String,
    val abilities: List<String>,
    val address: Address?,
    val campaigns: List<Campaign>
)

data class Address(
    val id: String,
    val state: String,
    val street: String,
    val number: String,
    val complement: String,
    val city: String,
    val zipCode: String,
    val neighborhood: String
)

data class Campaign(
    val id: String,
    val title: String,
    val description: String,
    val ongId: String,
    val donations: List<Donation>,
    val type: String,
    val badgeType: String,
    val monetaryGoal: Int,
    val donationGoal: Int
)

data class Donation(
    val id: String,
    val amount: Int,
    val donationDate: LocalDateTime,
    val quantity: Int,
    val donorId: String,
    val campaignId: String,
    val confirmed: Boolean
)

data class GetPostsResponse(
    val posts: List<Post>,
    val success: Boolean
)

data class CreatePostsResponse(
    val post: Post,
    val success: Boolean
)

data class CommentPostResponse(
    val success: Boolean,
    val comment: Comment
)

interface ForumService {
    @Multipart
    @POST("/api/posts")
    suspend fun createPost(
        @Part images: List<MultipartBody.Part>,
        @Part ("content") content: String
    ) : CreatePostsResponse

    @GET("/api/posts")
    suspend fun getPosts(): GetPostsResponse

    @POST("/api/posts/{id}/like")
    suspend fun likePost(@Path("id") id: String)

    @POST("/api/posts/{id}/comment")
    suspend fun commentPost(@Path("id") id: String, @Query("content") content: String): CommentPostResponse
}