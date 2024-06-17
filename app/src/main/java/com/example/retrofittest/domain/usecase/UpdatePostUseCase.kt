package com.example.retrofittest.domain.usecase

import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.data.model.PostData

class UpdatePostUseCase(
    private val repository: PostsRepository
) {
    suspend operator fun invoke(id: String, post: PostData) {
        try {
            repository.updatePost(id, post)
        } catch (e: Exception) {
            throw e
        }
    }
}