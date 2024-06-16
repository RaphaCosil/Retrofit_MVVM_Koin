package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository
import com.example.retrofittest.data.model.PostData
import retrofit2.Response

class PatchPostUseCase(
    private val service: PostsRepository
) {
    suspend fun invoke(id: String, post: PostData): Response<PostData> {
        return service.patchPost(id, post)
    }
}