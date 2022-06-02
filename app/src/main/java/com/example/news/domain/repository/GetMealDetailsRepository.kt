package com.example.news.domain.repository

import com.example.news.data.model.MealsDTO

interface GetMealDetailsRepository {
    suspend fun getMealDetails(id:String):MealsDTO
}