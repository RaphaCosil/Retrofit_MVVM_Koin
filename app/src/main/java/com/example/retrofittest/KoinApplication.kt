package com.example.retrofittest

import com.example.retrofittest.data.datasource.PostsService
import com.example.retrofittest.data.repository.PostsRepositoryImpl
import com.example.retrofittest.domain.repository.PostsRepository
import com.example.retrofittest.domain.usecase.PostsUseCase
import com.example.retrofittest.presentation.viewmodel.CreatePostViewModel
import com.example.retrofittest.presentation.viewmodel.GetAllPostsViewModel
import com.example.retrofittest.presentation.viewmodel.GetPostViewModel
import com.example.retrofittest.presentation.viewmodel.UpdatePostViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    // Instância singleton de PostsService configurada com Retrofit.
    single<PostsService> {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostsService::class.java)
    }
}
val dataModule = module {
    // Singleton de PostsRepository, injetando PostsService.
    factory<PostsRepository> {
        PostsRepositoryImpl(get())
    }
}

val domainModule = module {
    // Singleton do caso de uso, injetando PostsRepository.
    factory {
        PostsUseCase(get())
    }
}

val presentationModule = module {
    // ViewModels, injetando PostsUseCase.
    viewModel {
        GetAllPostsViewModel(get())
    }

    viewModel {
        GetPostViewModel(get())
    }

    viewModel {
        CreatePostViewModel(get())
    }

    viewModel {
        UpdatePostViewModel(get())
    }
}
