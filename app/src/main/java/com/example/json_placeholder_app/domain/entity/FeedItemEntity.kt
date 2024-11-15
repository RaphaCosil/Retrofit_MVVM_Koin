package com.example.json_placeholder_app.domain.entity

sealed class FeedItemEntity {
    data class PostItem(val postEntity: PostEntity) : FeedItemEntity()
    data class AlbumItem(val albumEntity: AlbumEntity) : FeedItemEntity()
}
