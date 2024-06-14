package com.example.retrofittest.domain.usecase

import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.model.PostData
import retrofit2.Response

class UpdatePostUseCase(
    private val repository: PostsRepository
) {
    suspend operator fun invoke(id: String, post: PostData): Response<PostData> {
        return repository.updatePost(id, post)
    }
}