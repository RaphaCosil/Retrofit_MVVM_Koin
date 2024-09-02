package com.example.retrofittest.domain.usecase

import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.domain.repository.PostsRepository
import retrofit2.Response

class PostsUseCase(
    private val repository: PostsRepository
) {
    suspend fun createPost(post: PostData) {
        try {
            repository.createPost(post)
        } catch (e: Exception) {
            throw e
        }
    }
    suspend fun updatePost(id: String, post: PostData) {
        try {
            repository.updatePost(id, post)
        } catch (e: Exception) {
            throw e
        }
    }
    suspend fun patchPost(id: String, post: PostData){
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
    suspend fun getPost(id: String): Response<PostData> {
        try {
            return repository.getPost(id)
        }
        catch (e: Exception) {
            throw e
        }
    }
    suspend fun getAllPosts(): Response<List<PostData>> {
        try {
            return repository.getAllPosts()
        } catch (e: Exception) {
            throw e
        }
    }
}