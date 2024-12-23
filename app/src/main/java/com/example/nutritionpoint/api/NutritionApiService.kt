package com.example.nutritionpoint.api

import com.example.nutritionpoint.FoodSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NutritionApiService {
    @GET("v1_1/search/{food_name}")
    suspend fun getFoodCalories(
        @Path("food_name") foodName: String,
        @Query("appId") appId: String,
        @Query("appKey") appKey: String
    ): Response<FoodSearchResponse>
}
