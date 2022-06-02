package com.example.news.presentation.meal_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.common.Resource
import com.example.news.domain.use_case.GetMealDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(private val getMealDetailsUseCase: GetMealDetailsUseCase) :
    ViewModel() {
    private val _mealDetails = MutableStateFlow<MealDetailsState>(MealDetailsState())
    val mealDetails: StateFlow<MealDetailsState> = _mealDetails

    fun getMealDetails(id: String) {
        getMealDetailsUseCase(id).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _mealDetails.value = MealDetailsState(isLoading = true)
                }
                is Resource.Success -> {
                    _mealDetails.value = MealDetailsState(data = result.data)
                }
                is Resource.Error -> {
                    _mealDetails.value = MealDetailsState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}