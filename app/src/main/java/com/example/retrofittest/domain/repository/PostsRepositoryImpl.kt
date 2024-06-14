package com.example.retrofittest.domain.repository

import com.example.retrofittest.data.PostsService
import com.example.retrofittest.model.PostData
import retrofit2.Response


class PostsRepositoryImpl(private val service: PostsService):PostsRepository {
    override suspend fun getTodos(): Response<List<PostData>> {
        return service.getPosts()
    }

    override suspend fun getPost(id: String): Response<PostData> {
        return service.getPost(id)
    }

    override suspend fun createPost(post: PostData): Response<PostData> {
        return service.createPost(post)
    }

    override suspend fun updatePost(id: String, post: PostData): Response<PostData> {
        return service.updatePost(id, post)
    }

    override suspend fun patchPost(id: String, post: PostData): Response<PostData> {
        return service.patchPost(id, post)
    }

    override suspend fun deletePost(id: String): Response<PostData> {
        return service.deletePost(id)
    }
}