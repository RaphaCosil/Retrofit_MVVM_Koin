package com.example.retrofittest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.retrofittest.domain.entity.PostEntity
import com.example.retrofittest.domain.usecase.PostsUseCase
import kotlinx.coroutines.launch

class UpdatePostViewModel(
    private val postsUseCase: PostsUseCase
): ViewModel(){

    private val _errorMessage = MutableLiveData<String>()

    val errorMessage: MutableLiveData<String> = _errorMessage

    private val _isUpdatedPost = MutableLiveData<Boolean>()

    val isUpdatedPost: MutableLiveData<Boolean> = _isUpdatedPost

    fun updatePost(id: String, post: PostEntity) {
        _isUpdatedPost.value = false
        viewModelScope.launch {
            try {
                val result = postsUseCase.updatePost(id, post).let {
                    _isUpdatedPost.value = true
                }
                Log.d("PostsViewModel", "updatePost result: $result")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
                _errorMessage.value = e.message
            }
        }
    }
}