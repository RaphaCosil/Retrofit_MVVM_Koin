package com.example.json_placeholder_app.data.repository

import com.example.json_placeholder_app.data.datasource.PostsService
import com.example.json_placeholder_app.data.model.toData
import com.example.json_placeholder_app.data.model.toEntity
import com.example.json_placeholder_app.domain.entity.PostEntity
import com.example.json_placeholder_app.domain.repository.PostsRepository

class PostsRepositoryImpl(private val service: PostsService): PostsRepository {
    override suspend fun getAllPosts(): List<PostEntity> {
        return service.getAllPosts().body()?.map { it.toEntity() } ?: emptyList()
    }

    override suspend fun getPost(id: String): PostEntity? {
        return service.getPost(id).body()?.toEntity()
    }

    override suspend fun createPost(post: PostEntity) {
        service.createPost(
            post.toData()
        )
    }

    override suspend fun updatePost(id: String, post: PostEntity) {
        service.updatePost(
            id,
            post.toData()
        )
    }

    override suspend fun patchPost(id: String, post: PostEntity) {
        service.patchPost(
            id,
            post.toData()
        )
    }

    override suspend fun deletePost(id: String) {
        service.deletePost(id)
    }
}