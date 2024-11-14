package com.example.json_placeholder_app.domain.usecase

import com.example.json_placeholder_app.domain.entity.PostEntity
import com.example.json_placeholder_app.domain.repository.PostsRepository

class PostsUseCase(
    private val repository: PostsRepository
) {
    suspend fun createPost(post: PostEntity) {
        try {
            repository.createPost(post)
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun updatePost(id: String, post: PostEntity) {
        try {
            repository.updatePost(id, post)
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun patchPost(id: String, post: PostEntity){
        try {
            repository.patchPost(id, post)
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun deletePost(id: String){
        try {
            repository.deletePost(id)
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun getPost(id: String): PostEntity? {
        try {
            return repository.getPost(id)
        }
        catch (e: Exception) {
            throw e
        }
    }

    suspend fun getAllPosts(): List<PostEntity> {
        try {
            return repository.getAllPosts()
        } catch (e: Exception) {
            throw e
        }
    }
}
