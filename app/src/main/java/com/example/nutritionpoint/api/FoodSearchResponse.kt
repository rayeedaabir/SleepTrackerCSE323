package com.example.nutritionpoint

data class FoodSearchResponse(
    val hits: List<FoodHit>
)

data class FoodHit(
    val fields: FoodFields
)

data class FoodFields(
    val item_name: String,
    val nf_calories: Float
)
