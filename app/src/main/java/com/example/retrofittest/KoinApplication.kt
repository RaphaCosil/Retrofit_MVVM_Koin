package com.example.retrofittest

import com.example.retrofittest.data.PostsService
import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.domain.usecase.*
import com.example.retrofittest.domain.repository.PostsRepositoryImpl
import com.example.retrofittest.viewmodel.PostsViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    // Provide Retrofit instance
    single<PostsService> {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostsService::class.java)
    }

    // Provide Repository
    single<PostsRepository> { PostsRepositoryImpl(get()) }

    // Provide Use Case
    single { GetPostsUseCase(get()) }
    single { GetPostUseCase(get()) }
    single { CreatePostUseCase(get()) }
    single { UpdatePostUseCase(get()) }
    single { DeletePostUseCase(get()) }


    // Provide ViewModel
    viewModel { PostsViewModel(get(), get(), get(), get(), get()) }
}
