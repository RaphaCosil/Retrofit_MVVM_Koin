package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository

class DeletePostUseCase(
    private val repository: PostsRepository
) {
    suspend operator fun invoke(id: String) = repository.deletePost(id)
}