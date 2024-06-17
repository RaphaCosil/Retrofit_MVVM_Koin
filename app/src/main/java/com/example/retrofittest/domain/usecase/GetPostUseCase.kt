package com.example.retrofittest.domain.usecase

import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.domain.repository.PostsRepository
import retrofit2.Response

class GetPostUseCase(private val repository: PostsRepository) {
    suspend operator fun invoke(id: String): Response<PostData> {
        try {
            return repository.getPost(id)
        }
        catch (e: Exception) {
            throw e
        }
    }
}