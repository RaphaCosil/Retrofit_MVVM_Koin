package com.example.retrofittest.data

import com.example.retrofittest.data.model.PostData
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
    suspend fun getAllPosts(): Response<List<PostData>>
    @GET("posts/{id}/")
    suspend fun getPost(@Path("id") id: String): Response<PostData>
    @POST("posts/")
    suspend fun createPost(@Body post: PostData): Response<PostData>
    @PUT("posts/{id}/")
    suspend fun updatePost(@Path("id") id: String, @Body post: PostData): Response<PostData>
    @PATCH("posts/{id}/")
    suspend fun patchPost(@Path("id") id: String, @Body post: PostData): Response<PostData>
    @DELETE("posts/{id}/")
    suspend fun deletePost(@Path("id") id: String): Response<PostData>
}