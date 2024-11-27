package com.helpline.network.search

import com.helpline.network.forum.User
import retrofit2.http.GET
import retrofit2.http.Query

data class SearchResponse(
    val success: Boolean,
    val users: List<User>
)

interface SearchService {
    @GET("/api/search/users")
    suspend fun search(@Query("name") name: String): SearchResponse
}