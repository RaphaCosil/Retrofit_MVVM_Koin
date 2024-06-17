package com.example.retrofittest.data.repository

import com.example.retrofittest.data.datasource.PostsService
import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.domain.repository.PostsRepository
import retrofit2.Response

class PostsRepositoryImpl(private val service: PostsService): PostsRepository {
    override suspend fun getAllPosts(): Response<List<PostData>> {
        return service.getAllPosts()
    }

    override suspend fun getPost(id: String): Response<PostData> {
        return service.getPost(id)
    }

    override suspend fun createPost(post: PostData) {
        service.createPost(post)
    }

    override suspend fun updatePost(id: String, post: PostData) {
        service.updatePost(id, post)
    }

    override suspend fun patchPost(id: String, post: PostData) {
        service.patchPost(id, post)
    }

    override suspend fun deletePost(id: String) {
        service.deletePost(id)
    }
}