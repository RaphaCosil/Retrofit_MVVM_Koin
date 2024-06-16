package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository
import com.example.retrofittest.data.model.PostData
import retrofit2.Response

class GetAllPostsUseCase(
    private val repository: PostsRepository
) {
    suspend operator fun invoke(): Response<List<PostData>> {
        return repository.getAllPosts()
    }
}