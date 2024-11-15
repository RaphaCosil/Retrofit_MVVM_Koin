package com.example.json_placeholder_app.data.model

data class CommentDAO(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)
