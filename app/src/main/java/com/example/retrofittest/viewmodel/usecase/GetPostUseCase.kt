package com.example.retrofittest.viewmodel.usecase

import com.example.retrofittest.data.repository.PostsRepository

class GetPostUseCase(private val repository: PostsRepository) {
    suspend operator fun invoke(id: String) = repository.getPost(id)
}