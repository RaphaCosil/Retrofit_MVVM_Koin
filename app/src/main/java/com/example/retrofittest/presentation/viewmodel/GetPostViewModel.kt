package com.example.retrofittest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.domain.entity.PostEntity
import com.example.retrofittest.domain.usecase.PostsUseCase
import kotlinx.coroutines.launch

class GetPostViewModel(
    private val postsUseCase: PostsUseCase
) : ViewModel() {
    private val _newPost = MutableLiveData<PostEntity>()

    val newPost: MutableLiveData<PostEntity> = _newPost

    fun getPost(id: String) {
        viewModelScope.launch {
            try {
                val result = postsUseCase.getPost(id)
                _newPost.value = result
                Log.d("PostsViewModel", "getPost result: $result")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
            }
        }
    }
}