package com.example.json_placeholder_app.data.datasource

import com.example.json_placeholder_app.data.model.AlbumDAO
import com.example.json_placeholder_app.data.model.CommentDAO
import com.example.json_placeholder_app.data.model.PhotoDAO
import com.example.json_placeholder_app.data.model.PostDAO
import com.example.json_placeholder_app.data.model.UserDAO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Service {

    @GET("posts?_limit=20")
    suspend fun getAllPosts(): Response<List<PostDAO>>

    @GET("posts?userId={id}")
    suspend fun getPostsByUserId(@Path("id") id: String): Response<List<PostDAO>>

    @POST("posts/")
    suspend fun createPost(@Body post: PostDAO)

    @GET("posts/{id}/comments/")
    suspend fun getPostComments(@Path("id") id: String): Response<List<CommentDAO>>

    @GET("albums?_limit=20")
    suspend fun getAlbums(): Response<List<AlbumDAO>>

    @POST("albums/")
    suspend fun createAlbum(@Body album: AlbumDAO)

    @GET("albums?userId={id}")
    suspend fun getAlbumsByUserId(@Path("id") id: String): Response<List<AlbumDAO>>

    @GET("photos?albumId={id}&_limit=5")
    suspend fun getPhotosByAlbumId(@Path("id") id: String): Response<List<PhotoDAO>>

    @GET("users/")
    suspend fun getUsers(): Response<List<UserDAO>>
}
