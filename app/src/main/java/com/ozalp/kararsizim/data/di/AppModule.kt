package com.ozalp.kararsizim.data.di

import com.ozalp.kararsizim.data.remote.api.CategoryAPI
import com.ozalp.kararsizim.data.repository.CategoryRepositoryImpl
import com.ozalp.kararsizim.domain.repository.CategoryRepository
import com.ozalp.kararsizim.domain.usecase.getCategories.GetCategoriesUseCase
import com.ozalp.kararsizim.presentation.viewmodel.CategoryDetailScreenViewModel
import com.ozalp.kararsizim.presentation.viewmodel.CategoryScreenViewModel
import com.ozalp.kararsizim.util.Constant
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<CategoryAPI> {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryAPI::class.java)
    }

    viewModel {
        CategoryScreenViewModel(get())
    }
    viewModel {
        CategoryDetailScreenViewModel(get())
    }


    single<CategoryRepository> {
        CategoryRepositoryImpl(get())
    }

    factory {
        GetCategoriesUseCase(get())
    }


}