package com.example.json_placeholder_app.domain.repository

import com.example.json_placeholder_app.domain.entity.PostEntity

interface PostsRepository {
    suspend fun getAllPosts(): List<PostEntity>
    suspend fun createPost(post: PostEntity)
}
