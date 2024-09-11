package com.example.retrofittest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.domain.usecase.PostsUseCase
import kotlinx.coroutines.launch

class GetAllPostsViewModel(
    private val postsUseCase: PostsUseCase
) : ViewModel() {

    private val _posts = MutableLiveData<List<PostData>>()

    val posts: LiveData<List<PostData>> = _posts

    fun getPosts() {
        viewModelScope.launch {
            try {
                val result = postsUseCase.getAllPosts()
                _posts.value = result.body()
                Log.d("PostsViewModel", "getPosts result: ${result.body() }")

            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
            }
        }
    }
}