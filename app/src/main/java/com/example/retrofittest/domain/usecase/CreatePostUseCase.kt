package com.example.retrofittest.domain.usecase

import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.model.PostData
import retrofit2.Response

class CreatePostUseCase(private val repository: PostsRepository) {
    suspend fun invoke(post: PostData): Response<PostData> {
        return repository.createPost(post)
    }
}