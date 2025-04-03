package com.ozalp.kararsizim.util.mapper

import com.ozalp.kararsizim.data.remote.dto.ActivityDto
import com.ozalp.kararsizim.domain.model.Activity

object ActivityMapper {

    fun activityDtoToActivity(activityDtos: List<ActivityDto>): List<Activity> {
        return activityDtos.map {
            Activity(it.activity_description, it.activity_title, it.categories.category_name, it.id)
        }
    }
}