package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository
import com.example.retrofittest.data.model.PostData
import retrofit2.Response

class UpdatePostUseCase(
    private val repository: PostsRepository
) {
    suspend operator fun invoke(id: String, post: PostData): Response<PostData> {
        return repository.updatePost(id, post)
    }
}