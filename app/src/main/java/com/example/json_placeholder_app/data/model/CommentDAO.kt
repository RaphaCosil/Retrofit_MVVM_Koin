package com.example.json_placeholder_app.data.model

import com.example.json_placeholder_app.domain.entity.CommentEntity

data class CommentDAO(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)

fun CommentEntity.toData(): CommentDAO {
    return CommentDAO(
        postId = postId,
        id = id,
        name = name,
        email = email,
        body = body
    )
}

fun CommentDAO.toEntity(): CommentEntity {
    return CommentEntity(
        postId = postId,
        id = id,
        name = name,
        email = email,
        body = body
    )
}
