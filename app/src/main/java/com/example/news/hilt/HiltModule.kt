package com.example.news.hilt

import com.example.news.common.Constants
import com.example.news.data.remote.MealSearchAPI
import com.example.news.data.repository.GetMealDetailsImpl
import com.example.news.data.repository.GetMealListImpl
import com.example.news.domain.repository.GetMealDetailsRepository
import com.example.news.domain.repository.MealSearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {
    @Provides
    @Singleton
    fun provideMealSearchAPI(): MealSearchAPI {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(MealSearchAPI::class.java)
    }

    @Provides
    fun provideMealSearchRepository(mealSearchAPI: MealSearchAPI): MealSearchRepository {
        return GetMealListImpl(mealSearchAPI)
    }

    @Provides
    fun provideMealDetailsRepository(mealSearchAPI: MealSearchAPI): GetMealDetailsRepository {
        return GetMealDetailsImpl(mealSearchAPI)
    }

}