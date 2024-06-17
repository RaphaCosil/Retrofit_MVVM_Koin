package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository

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