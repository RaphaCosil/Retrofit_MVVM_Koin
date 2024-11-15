package com.example.json_placeholder_app.domain.usecase

import com.example.json_placeholder_app.domain.entity.UserEntity
import com.example.json_placeholder_app.domain.repository.AppRepository

class GetAllUsersUseCase(
    private val repository: AppRepository
) {
    suspend operator fun invoke(): List<UserEntity> {
        return repository.getAllUsers()
    }
}
