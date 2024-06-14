package com.example.retrofittest.domain.usecase

import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.model.PostData
import retrofit2.Response

class GetPostsUseCase(
    private val repository: PostsRepository
) {
    suspend operator fun invoke(): Response<List<PostData>> {
        return repository.getTodos()
    }
}