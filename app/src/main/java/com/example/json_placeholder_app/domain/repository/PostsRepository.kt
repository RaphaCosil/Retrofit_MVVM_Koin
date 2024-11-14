package com.example.json_placeholder_app.domain.repository

import com.example.json_placeholder_app.domain.entity.PostEntity

interface PostsRepository {
    suspend fun getAllPosts(): List<PostEntity>
    suspend fun getPost(id: String): PostEntity?
    suspend fun createPost(post: PostEntity)
    suspend fun updatePost(id: String, post: PostEntity)
    suspend fun patchPost(id: String, post: PostEntity)
    suspend fun deletePost(id: String)
}