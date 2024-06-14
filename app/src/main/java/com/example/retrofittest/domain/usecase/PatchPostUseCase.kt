package com.example.retrofittest.domain.usecase

import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.model.PostData
import retrofit2.Response

class PatchPostUseCase(
    private val service: PostsRepository
) {
    suspend fun invoke(id: String, post: PostData): Response<PostData> {
        return service.patchPost(id, post)
    }
}