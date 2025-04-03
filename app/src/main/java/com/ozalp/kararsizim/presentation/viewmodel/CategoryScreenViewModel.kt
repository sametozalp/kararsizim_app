package com.ozalp.kararsizim.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozalp.kararsizim.domain.usecase.categoryUseCase.GetCategoriesUseCase
import com.ozalp.kararsizim.presentation.state.CategoryScreenState
import com.ozalp.kararsizim.util.Resource
import kotlinx.coroutines.launch

class CategoryScreenViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
) :
    ViewModel() {

    private val _categoryScreenState = mutableStateOf(CategoryScreenState())
    val categoryScreenState get() = _categoryScreenState

    init {
        getCategories()
    }

    fun getCategories() {

        if (categoryScreenState.value.isLoading)
            return

        viewModelScope.launch {

            getCategoriesUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        _categoryScreenState.value = _categoryScreenState.value.copy(
                            categories = it.data ?: emptyList(),
                            error = "",
                            isLoading = false
                        )

                    }

                    is Resource.Error -> {
                        _categoryScreenState.value = _categoryScreenState.value.copy(
                            categories = emptyList(),
                            error = it.message ?: "",
                            isLoading = false
                        )


                    }

                    is Resource.Loading -> {
                        _categoryScreenState.value = _categoryScreenState.value.copy(
                            categories = emptyList(),
                            error = "",
                            isLoading = true
                        )

                    }
                }
            }


        }
    }
}