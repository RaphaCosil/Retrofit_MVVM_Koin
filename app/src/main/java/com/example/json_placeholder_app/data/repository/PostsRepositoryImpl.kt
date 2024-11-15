package com.example.json_placeholder_app.data.repository

import com.example.json_placeholder_app.data.datasource.Service
import com.example.json_placeholder_app.data.model.toData
import com.example.json_placeholder_app.data.model.toEntity
import com.example.json_placeholder_app.domain.entity.PostEntity
import com.example.json_placeholder_app.domain.repository.PostsRepository

class PostsRepositoryImpl(private val service: Service): PostsRepository {
    override suspend fun getAllPosts(): List<PostEntity> {
        return service.getAllPosts().body()?.map { it.toEntity() } ?: emptyList()
    }

    override suspend fun createPost(post: PostEntity) {
        service.createPost(
            post.toData()
        )
    }
}