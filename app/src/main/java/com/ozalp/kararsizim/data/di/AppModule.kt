package com.ozalp.kararsizim.data.di

import com.ozalp.kararsizim.data.remote.api.ActivityAPI
import com.ozalp.kararsizim.data.remote.api.CategoryAPI
import com.ozalp.kararsizim.data.remote.api.TelegramMessageAPI
import com.ozalp.kararsizim.data.repository.ActivityRepositoryImpl
import com.ozalp.kararsizim.data.repository.CategoryRepositoryImpl
import com.ozalp.kararsizim.data.repository.TelegramMessageRepositoryImpl
import com.ozalp.kararsizim.domain.repository.ActivityRepository
import com.ozalp.kararsizim.domain.repository.CategoryRepository
import com.ozalp.kararsizim.domain.repository.TelegramMessageRepository
import com.ozalp.kararsizim.domain.usecase.activityUseCase.GetActivitiesUseCase
import com.ozalp.kararsizim.domain.usecase.categoryUseCase.GetCategoriesUseCase
import com.ozalp.kararsizim.domain.usecase.telegramMessageUseCase.SendMessageUseCase
import com.ozalp.kararsizim.presentation.viewmodel.CategoryDetailScreenViewModel
import com.ozalp.kararsizim.presentation.viewmodel.CategoryScreenViewModel
import com.ozalp.kararsizim.presentation.viewmodel.HaveAProblemScreenViewModel
import com.ozalp.kararsizim.util.Constant
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    single<TelegramMessageAPI> {
        Retrofit.Builder()
            .baseUrl("https:sametozalp.com")
            //.addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TelegramMessageAPI::class.java)
    }

    single<CategoryAPI> {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryAPI::class.java)
    }

    single<ActivityAPI> {

        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ActivityAPI::class.java)
    }

    viewModel {
        CategoryScreenViewModel(get())
    }
    viewModel {
        CategoryDetailScreenViewModel(get(), get())
    }

    viewModel {
        HaveAProblemScreenViewModel(get())
    }

    single<CategoryRepository> {
        CategoryRepositoryImpl(get())
    }

    single<ActivityRepository> {
        ActivityRepositoryImpl(get())
    }

    single<TelegramMessageRepository> {
        TelegramMessageRepositoryImpl(get())
    }

    factory {
        GetCategoriesUseCase(get())
    }

    factory {
        GetActivitiesUseCase(get())
    }

    factory {
        SendMessageUseCase(get())
    }

}