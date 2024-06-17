package com.example.retrofittest.domain.usecase

import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.data.model.PostData
import retrofit2.Response

class GetAllPostsUseCase(
    private val repository: PostsRepository
) {
    suspend operator fun invoke(): Response<List<PostData>> {
        try {
            return repository.getAllPosts()
        } catch (e: Exception) {
            throw e
        }
    }
}