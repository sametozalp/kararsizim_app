package com.ozalp.kararsizim.presentation.state

import com.ozalp.kararsizim.domain.model.Activity

data class CategoryScreenDetailState(
    var categoryId: String = "",
    var isLoading: Boolean = false,
    var error: String = "",
//    var activity: Activity = Activity("", "", "", -1),
    var activityList: List<Activity> = arrayListOf(),
    var index: Int = 0,

    )