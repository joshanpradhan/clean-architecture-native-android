package com.example.news.data.repository

import com.example.news.data.model.MealsDTO
import com.example.news.data.remote.MealSearchAPI
import com.example.news.domain.repository.GetMealDetailsRepository

class GetMealDetailsImpl(private val mealSearchAPI: MealSearchAPI):GetMealDetailsRepository {
    override suspend fun getMealDetails(id: String): MealsDTO {
        return mealSearchAPI.getMealDetails(id)
    }
}