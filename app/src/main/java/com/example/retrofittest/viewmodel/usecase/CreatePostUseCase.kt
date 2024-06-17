package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository
import com.example.retrofittest.data.model.PostData

class CreatePostUseCase(private val repository: PostsRepository) {
    suspend fun invoke(post: PostData) {
        try {
            repository.createPost(post)
        } catch (e: Exception) {
            throw e
        }
    }
}