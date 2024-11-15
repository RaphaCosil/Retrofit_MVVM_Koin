package com.example.json_placeholder_app.data.model

import com.example.json_placeholder_app.domain.entity.UserEntity

data class UserDAO(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
)

fun UserEntity.toData(): UserDAO {
    return UserDAO(
        id = id,
        name = name,
        username = username,
        email = email
    )
}

fun UserDAO.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        name = name,
        username = username,
        email = email
    )
}
