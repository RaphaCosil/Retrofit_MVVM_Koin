package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository
import com.example.retrofittest.data.model.PostData
import retrofit2.Response

class CreatePostUseCase(private val repository: PostsRepository) {
    suspend fun invoke(post: PostData): Response<PostData> {
        return repository.createPost(post)
    }
}