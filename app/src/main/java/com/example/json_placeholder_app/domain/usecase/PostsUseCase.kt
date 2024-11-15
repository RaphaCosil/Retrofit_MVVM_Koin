package com.example.json_placeholder_app.domain.usecase

import com.example.json_placeholder_app.domain.entity.PostEntity
import com.example.json_placeholder_app.domain.repository.PostsRepository

class PostsUseCase(
    private val repository: PostsRepository
) {
    suspend fun createPost(post: PostEntity) {
        try {
            repository.createPost(post)
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun getAllPosts(): List<PostEntity> {
        try {
            return repository.getAllPosts()
        } catch (e: Exception) {
            throw e
        }
    }
}
