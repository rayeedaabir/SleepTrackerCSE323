package com.example.nutritionpoint

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nutritionpoint.api.NutritionApiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DietTrackerActivity : AppCompatActivity() {
    private lateinit var retrofit: Retrofit
    private lateinit var nutritionApiService: NutritionApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet_tracker) // Referencing the XML layout

        // Initialize Retrofit
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.nutritionix.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create an instance of the API service
        nutritionApiService = retrofit.create(NutritionApiService::class.java)

        // Set the button's onClick listener to search for food
        findViewById<Button>(R.id.search_food_button).setOnClickListener {
            val foodName = findViewById<EditText>(R.id.food_name_edittext).text.toString()
            fetchFoodCalories(foodName)
        }
    }

    // Function to fetch food calories using the API
    private fun fetchFoodCalories(foodName: String) {
        val appId = "YOUR_APP_ID" // Replace with your Nutritionix API appId
        val appKey = "YOUR_APP_KEY" // Replace with your Nutritionix API appKey

        GlobalScope.launch {
            val response = nutritionApiService.getFoodCalories(foodName, appId, appKey)
            if (response.isSuccessful) {
                val calories = response.body()?.hits?.get(0)?.fields?.nf_calories
                runOnUiThread {
                    // Update the calories TextView
                    findViewById<TextView>(R.id.calories_textview).text = "Calories: $calories"
                }
            }
        }
    }
}
