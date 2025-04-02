package com.ozalp.kararsizim.presentation.state

import com.ozalp.kararsizim.domain.model.Category

data class CategoryScreenState(
    var isLoading: Boolean = false,
    var error: String = "",
    var categories: List<Category> = arrayListOf()
)
