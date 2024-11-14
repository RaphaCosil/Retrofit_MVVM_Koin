package com.example.json_placeholder_app.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.json_placeholder_app.domain.entity.PostEntity
import com.example.json_placeholder_app.domain.usecase.PostsUseCase
import kotlinx.coroutines.launch

class GetAllPostsViewModel(
    private val postsUseCase: PostsUseCase
) : ViewModel() {
     val posts = MutableLiveData<List<PostEntity>>()
    fun getPosts() {
        viewModelScope.launch {
            try {
                val result = postsUseCase.getAllPosts()
                posts.value = result
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
            }
        }
    }
}