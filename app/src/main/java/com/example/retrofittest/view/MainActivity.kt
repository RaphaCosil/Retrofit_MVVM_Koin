package com.example.retrofittest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofittest.R
import com.example.retrofittest.RetrofitInstance
import com.example.retrofittest.appModule
import com.example.retrofittest.domain.repository.PostsRepositoryImpl
import com.example.retrofittest.domain.usecase.*
import com.example.retrofittest.model.PostData
import com.example.retrofittest.viewmodel.PostsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }
        val retrofitRepository = PostsRepositoryImpl(RetrofitInstance.api)
        val userViewModel = PostsViewModel(
            GetPostsUseCase(retrofitRepository),
            GetPostUseCase(retrofitRepository),
            CreatePostUseCase(retrofitRepository),
            UpdatePostUseCase(retrofitRepository),
            DeletePostUseCase(retrofitRepository)
        )

        userViewModel.getPosts()
//        userViewModel.getPost("1")
//        userViewModel.createPost(PostData(1, "title", "body", 1))
//        userViewModel.updatePost("1", PostData(1, "title", "body", 1))
//        userViewModel.deletePost("1")
    }
}