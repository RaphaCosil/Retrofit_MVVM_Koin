package com.example.retrofittest

import com.example.retrofittest.data.datasource.PostsService
import com.example.retrofittest.data.repository.PostsRepositoryImpl
import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.domain.usecase.PostsUseCase
import com.example.retrofittest.presentation.viewmodel.PostsViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<PostsService> {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostsService::class.java)
    }

    single<PostsRepository> {
        PostsRepositoryImpl(get())
    }

    single {
        PostsUseCase(get())
    }

    viewModel {
        PostsViewModel(get())
    }
}
