package com.example.json_placeholder_app.domain.entity

data class AlbumEntity(
    val userId: Int,
    val id: Int,
    val title: String,
    var photos: List<PhotoEntity>,
    var userName: String
)
