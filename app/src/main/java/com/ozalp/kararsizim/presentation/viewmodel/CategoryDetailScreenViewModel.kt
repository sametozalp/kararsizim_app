package com.ozalp.kararsizim.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozalp.kararsizim.domain.usecase.activityUseCase.GetActivitiesUseCase
import com.ozalp.kararsizim.presentation.state.CategoryScreenDetailState
import com.ozalp.kararsizim.util.CategoryDetailScreenDestination
import com.ozalp.kararsizim.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigInteger

class CategoryDetailScreenViewModel(
    private val getActivitiesUseCase: GetActivitiesUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val categoryScreenDetailState = mutableStateOf(CategoryScreenDetailState())

    init {
        val categoryId: String =
            savedStateHandle[CategoryDetailScreenDestination.argCategoryId] ?: ""
        println("CategoryId: $categoryId")
        categoryScreenDetailState.value =
            categoryScreenDetailState.value.copy(categoryId = categoryId)

        getActivities()
    }

    fun getActivities() {

        if (categoryScreenDetailState.value.isLoading) return

        viewModelScope.launch {
            getActivitiesUseCase(categoryScreenDetailState.value.categoryId).collect {
                when (it) {
                    is Resource.Success -> {
                        categoryScreenDetailState.value = categoryScreenDetailState.value.copy(
                            error = "",
                            isLoading = false,
                            activity = it.data ?: arrayListOf()
                        )
                    }

                    is Resource.Error -> {
                        categoryScreenDetailState.value = categoryScreenDetailState.value.copy(
                            error = it.message ?: "",
                            isLoading = false,
                            activity = arrayListOf()
                        )
                    }

                    is Resource.Loading -> {
                        categoryScreenDetailState.value = categoryScreenDetailState.value.copy(
                            error = "",
                            isLoading = true,
                            activity = arrayListOf()
                        )
                    }
                }
            }
        }
    }
}