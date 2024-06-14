package com.example.retrofittest.domain.usecase

import com.example.retrofittest.domain.repository.PostsRepository

class GetPostUseCase(private val repository: PostsRepository) {
    suspend operator fun invoke(id: String) = repository.getPost(id)
}