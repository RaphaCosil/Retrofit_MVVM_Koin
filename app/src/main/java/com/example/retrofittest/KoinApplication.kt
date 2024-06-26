package com.example.retrofittest

import com.example.retrofittest.data.datasource.PostsService
import com.example.retrofittest.data.repository.PostsRepositoryImpl
import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.presentation.viewmodel.PostsViewModel
import com.example.retrofittest.domain.usecase.CreatePostUseCase
import com.example.retrofittest.domain.usecase.DeletePostUseCase
import com.example.retrofittest.domain.usecase.GetPostUseCase
import com.example.retrofittest.domain.usecase.GetAllPostsUseCase
import com.example.retrofittest.domain.usecase.PatchPostUseCase
import com.example.retrofittest.domain.usecase.UpdatePostUseCase

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
    single { GetAllPostsUseCase(get()) }
    single { GetPostUseCase(get()) }
    single { CreatePostUseCase(get()) }
    single { UpdatePostUseCase(get()) }
    single { PatchPostUseCase(get()) }
    single { DeletePostUseCase(get()) }

    // Provide ViewModel
    viewModel { PostsViewModel(get(), get(), get(), get(), get(), get()) }
}
