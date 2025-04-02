package com.ozalp.kararsizim.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozalp.kararsizim.data.remote.api.CategoryAPI
import com.ozalp.kararsizim.domain.usecase.getCategories.GetCategoriesUseCase
import kotlinx.coroutines.launch

class CategoryScreenViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase
) :
    ViewModel() {

    init {
        getCategories()
    }

    fun getCategories() {

        viewModelScope.launch {

            val categoryList = getCategoriesUseCase()
            println(categoryList)


        }
    }
}