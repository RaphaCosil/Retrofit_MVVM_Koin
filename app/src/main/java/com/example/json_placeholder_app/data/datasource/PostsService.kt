package com.example.json_placeholder_app.data.datasource

import com.example.json_placeholder_app.data.model.PostDAO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PostsService {
    @GET("posts/")
    suspend fun getAllPosts(): Response<List<PostDAO>>
    @GET("posts/{id}/")
    suspend fun getPost(@Path("id") id: String): Response<PostDAO>
    @POST("posts/")
    suspend fun createPost(@Body post: PostDAO)
    @PUT("posts/{id}/")
    suspend fun updatePost(@Path("id") id: String, @Body post: PostDAO)
    @PATCH("posts/{id}/")
    suspend fun patchPost(@Path("id") id: String, @Body post: PostDAO)
    @DELETE("posts/{id}/")
    suspend fun deletePost(@Path("id") id: String)
}
