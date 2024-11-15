package com.example.json_placeholder_app.domain.usecase

import com.example.json_placeholder_app.domain.entity.PostEntity
import com.example.json_placeholder_app.domain.repository.AppRepository

class CreatePostUseCase(
    private val repository: AppRepository
) {
    suspend operator fun invoke(post: PostEntity) {
        repository.createPost(post)
    }
}
