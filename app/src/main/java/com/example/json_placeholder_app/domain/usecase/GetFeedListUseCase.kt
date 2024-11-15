package com.example.json_placeholder_app.domain.usecase

import com.example.json_placeholder_app.domain.repository.AppRepository

class GetFeedListUseCase(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): List<Any> {
        return repository.getFeedList()
    }
}
