package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository
import com.example.retrofittest.data.model.PostData

class PatchPostUseCase(
    private val service: PostsRepository
) {
    suspend fun invoke(id: String, post: PostData){
        try {
            service.patchPost(id, post)
        } catch (e: Exception) {
            throw e
        }
    }
}