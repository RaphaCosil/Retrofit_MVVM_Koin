package com.example.json_placeholder_app.domain.repository

import com.example.json_placeholder_app.domain.entity.AlbumEntity
import com.example.json_placeholder_app.domain.entity.CommentEntity
import com.example.json_placeholder_app.domain.entity.PostEntity
import com.example.json_placeholder_app.domain.entity.UserEntity

interface AppRepository {
    suspend fun getFeedList(): List<Any>
    suspend fun getPostsByUserId(id: String): List<PostEntity>
    suspend fun getPostComments(id: String): List<CommentEntity>
    suspend fun createPost(post: PostEntity)
    suspend fun getAlbumsByUserId(id: String): List<AlbumEntity>
    suspend fun createAlbum(album: AlbumEntity)
    suspend fun getAllUsers(): List<UserEntity>
}
