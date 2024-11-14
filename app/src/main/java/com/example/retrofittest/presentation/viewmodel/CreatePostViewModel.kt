package com.example.retrofittest.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.domain.entity.PostEntity
import com.example.retrofittest.domain.usecase.PostsUseCase
import kotlinx.coroutines.launch

class CreatePostViewModel(
    private val postsUseCase: PostsUseCase
): ViewModel() {

    private val _errorMessage = MutableLiveData<String>()

    val errorMessage: MutableLiveData<String> = _errorMessage

    private val _isCreated = MutableLiveData<Boolean>()
    val isCreated: LiveData<Boolean> = _isCreated
    fun createPost(post: PostEntity) {
        viewModelScope.launch {
            try {
                val result = postsUseCase.createPost(post).let {
                    _isCreated.value = true
                }
                Log.d("PostsViewModel", "createPost result: $result")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
                _errorMessage.value = e.message
            }
        }
    }
}