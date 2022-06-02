package com.example.news.presentation.meal_details

import com.example.news.domain.model.MealDetails

data class MealDetailsState(
    val data: MealDetails? = null,
    val error: String = "",
    val isLoading: Boolean = false
) {

}
