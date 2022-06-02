package com.example.news.presentation.meal_search

import com.example.news.domain.model.Meal

data class MealSearchState(
    val isLoading: Boolean = false,
    val data: List<Meal>? = null,
    val error: String = "",
) {

}
