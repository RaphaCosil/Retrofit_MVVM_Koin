package com.example.retrofittest.domain.repository

import com.example.retrofittest.data.model.PostData
import retrofit2.Response

interface PostsRepository {
    suspend fun getAllPosts(): Response<List<PostData>>
    suspend fun getPost(id: String): Response<PostData>
    suspend fun createPost(post: PostData)
    suspend fun updatePost(id: String, post: PostData)
    suspend fun patchPost(id: String, post: PostData)
    suspend fun deletePost(id: String)

}