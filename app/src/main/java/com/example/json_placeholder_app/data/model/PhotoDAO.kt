package com.example.json_placeholder_app.data.model

import com.example.json_placeholder_app.domain.entity.PhotoEntity

data class PhotoDAO (
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)

fun PhotoEntity.toData(): PhotoDAO {
    return PhotoDAO(
        albumId = albumId,
        id = id,
        title = title,
        url = url,
        thumbnailUrl = thumbnailUrl
    )
}

fun PhotoDAO.toEntity(): PhotoEntity {
    return PhotoEntity(
        albumId = albumId,
        id = id,
        title = title,
        url = url,
        thumbnailUrl = thumbnailUrl
    )
}
