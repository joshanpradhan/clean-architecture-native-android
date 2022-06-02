package com.example.news.data.repository

import com.example.news.data.model.MealsDTO
import com.example.news.data.remote.MealSearchAPI
import com.example.news.domain.repository.MealSearchRepository

class GetMealListImpl(private val mealSearchAPI: MealSearchAPI):MealSearchRepository {
    override suspend fun getMealList(s: String): MealsDTO {
        return mealSearchAPI.getMealList(s)
    }
}