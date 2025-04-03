package com.ozalp.kararsizim.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ozalp.kararsizim.presentation.state.CategoryScreenDetailState
import com.ozalp.kararsizim.util.CategoryDetailScreenDestination

class CategoryDetailScreenViewModel(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val categoryScreenDetailState = mutableStateOf(CategoryScreenDetailState())

    init {
        val categoryId: String =
            savedStateHandle[CategoryDetailScreenDestination.argCategoryId] ?: ""
        println("CategoryId: $categoryId")
        categoryScreenDetailState.value =
            categoryScreenDetailState.value.copy(categoryId = categoryId)
    }
}