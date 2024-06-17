package com.example.retrofittest.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.retrofittest.data.model.PostData
import com.example.retrofittest.viewmodel.usecase.CreatePostUseCase
import com.example.retrofittest.viewmodel.usecase.DeletePostUseCase
import com.example.retrofittest.viewmodel.usecase.GetPostUseCase
import com.example.retrofittest.viewmodel.usecase.GetAllPostsUseCase
import com.example.retrofittest.viewmodel.usecase.PatchPostUseCase
import com.example.retrofittest.viewmodel.usecase.UpdatePostUseCase
import kotlinx.coroutines.launch

class PostsViewModel(
    private val getPostsUseCase: GetAllPostsUseCase,
    private val getPostUseCase: GetPostUseCase,
    private val createPostUseCase: CreatePostUseCase,
    private val putPostUseCase: UpdatePostUseCase,
    private val patchPostUseCase: PatchPostUseCase,
    private val deletePostUseCase: DeletePostUseCase
) : ViewModel() {

    private val _posts = MutableLiveData<List<PostData>>()
    val posts: LiveData<List<PostData>> = _posts

    fun getPosts() {
        viewModelScope.launch {
            try {
                val result = getPostsUseCase.invoke()
                _posts.value = result.body()
                Log.d("PostsViewModel", "getPosts result: ${result.body() }")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
                // Handle the error
            }
        }
    }
    fun getPost(id: String) {
        viewModelScope.launch {
            try {
                val result = getPostUseCase.invoke(id)
                Log.d("PostsViewModel", "getPost result: ${result.body() }")
            } catch (e: Exception) {
                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
                // Handle the error
            }
        }
    }

//    fun createPost(post: PostData) {
//        viewModelScope.launch {
//            try {
//                val result = createPostUseCase.invoke(post)
//                Log.d("PostsViewModel", "createPost result: ${result.body() }")
//            } catch (e: Exception) {
//                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
//                // Handle the error
//            }
//        }
//    }
//
//    fun updatePost(id: String, post: PostData) {
//        viewModelScope.launch {
//            try {
//                val result = putPostUseCase.invoke(id, post)
//                Log.d("PostsViewModel", "updatePost result: ${result.body() }")
//            } catch (e: Exception) {
//                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
//                // Handle the error
//            }
//        }
//    }
//
//    fun patchPost(id: String, post: PostData) {
//        viewModelScope.launch {
//            try {
//                val result = patchPostUseCase.invoke(id, post)
//                Log.d("PostsViewModel", "patchPost result: ${result.body() }")
//            } catch (e: Exception) {
//                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
//                // Handle the error
//            }
//        }
//    }
//
//    fun deletePost(id: String) {
//        viewModelScope.launch {
//            try {
//                val result = deletePostUseCase.invoke(id)
//                Log.d("PostsViewModel", "deletePost result: ${result.body() }")
//            } catch (e: Exception) {
//                Log.e("PostsViewModel", "Error fetching todos | MESSAGE ${e.message} | CAUSE ${e.cause}")
//                // Handle the error
//            }
//        }
//    }
}