package com.example.json_placeholder_app.data.model

import com.example.json_placeholder_app.domain.entity.PostEntity

data class PostDAO(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun PostEntity.toData(): PostDAO {
    return PostDAO(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}

fun PostDAO.toEntity(): PostEntity {
    return PostEntity(
        userId = userId,
        id = id,
        title = title,
        body = body,
        userName = ""
    )
}
