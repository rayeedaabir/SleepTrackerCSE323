package com.example.nutritionpoint

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)  // Your StartActivity layout XML file
    }

    // This function is called when the start button is clicked
    fun onStartButtonClick(view: View) {
        val intent = Intent(this, SleepTrackerActivity::class.java)
        startActivity(intent)
    }
}
