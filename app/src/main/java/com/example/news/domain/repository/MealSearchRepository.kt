package com.example.news.domain.repository

import com.example.news.data.model.MealsDTO

interface MealSearchRepository {
    suspend fun getMealList(s:String ):MealsDTO
}