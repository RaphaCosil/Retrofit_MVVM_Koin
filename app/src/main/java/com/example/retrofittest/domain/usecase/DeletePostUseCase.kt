package com.example.retrofittest.domain.usecase

import com.example.retrofittest.domain.repository.PostsRepository

class DeletePostUseCase(
    private val repository: PostsRepository
) {
    suspend operator fun invoke(id: String){
        try {
            repository.deletePost(id)
        } catch (e: Exception) {
            throw e
        }
    }
}