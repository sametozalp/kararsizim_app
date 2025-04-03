package com.ozalp.kararsizim.domain.usecase.activityUseCase

import com.ozalp.kararsizim.domain.model.Activity
import com.ozalp.kararsizim.domain.repository.ActivityRepository
import com.ozalp.kararsizim.util.Resource
import com.ozalp.kararsizim.util.mapper.ActivityMapper
import com.ozalp.kararsizim.util.mapper.CategoryMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.math.BigInteger

class GetActivitiesUseCase(private val acitivityRepository: ActivityRepository) {

    suspend operator fun invoke(categoryId: Int): Flow<Resource<List<Activity>>> = flow {
        emit(Resource.Loading())

        val activityList =
            ActivityMapper.activityDtoToActivity(acitivityRepository.getActivities(categoryId))
        emit(Resource.Success(activityList))

    }.catch { e ->
        emit(Resource.Error(e.localizedMessage ?: "Error", arrayListOf()))
    }
}