package com.example.news.domain.use_case

import android.util.Log
import com.example.news.common.Resource
import com.example.news.data.model.toDomainMealDetails
import com.example.news.domain.model.MealDetails
import com.example.news.domain.repository.GetMealDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
class GetMealDetailsUseCase @Inject constructor(private val repository: GetMealDetailsRepository) {
    operator fun invoke(id: String): Flow<Resource<MealDetails>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getMealDetails(id).meals[0].toDomainMealDetails()
            emit(Resource.Success(data = response))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown error"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check your internet connection"))
        }
    }
}