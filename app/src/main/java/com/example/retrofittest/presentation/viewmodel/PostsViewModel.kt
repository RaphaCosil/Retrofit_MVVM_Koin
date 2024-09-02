package com.example.retrofittest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.domain.usecase.PostsUseCase
import kotlinx.coroutines.launch

class PostsViewModel(
    private val postsUseCase: PostsUseCase
) : ViewModel() {

    var posts = MutableLiveData<List<PostData>>()

    fun getPosts() {
        viewModelScope.launch {
            try {
                val result = postsUseCase.getAllPosts()
                posts.value = result.body()
                Log.d("PostsViewModel", "getPosts result: ${result.body() }")

            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
            }
        }
    }
    fun getPost(id: String) {
        viewModelScope.launch {
            try {
                val result = postsUseCase.getPost(id)
                Log.d("PostsViewModel", "getPost result: ${result.body() }")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
            }
        }
    }

    fun createPost(post: PostData) {
        viewModelScope.launch {
            try {
                val result = postsUseCase.createPost(post)
                Log.d("PostsViewModel", "createPost result: $result")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
                // Handle the error
            }
        }
    }

    fun updatePost(id: String, post: PostData) {
        viewModelScope.launch {
            try {
                val result = postsUseCase.updatePost(id, post)
                Log.d("PostsViewModel", "updatePost result: $result")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
                // Handle the error
            }
        }
    }

    fun patchPost(id: String, post: PostData) {
        viewModelScope.launch {
            try {
                val result = postsUseCase.patchPost(id, post)
                Log.d("PostsViewModel", "patchPost result: $result")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
                // Handle the error
            }
        }
    }

    fun deletePost(id: String) {
        viewModelScope.launch {
            try {
                val result = postsUseCase.deletePost(id)
                Log.d("PostsViewModel", "deletePost result: $result")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
                // Handle the error
            }
        }
    }
}