package com.example.nutritionpoint

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.nutritionpoint.database.SleepData
import com.example.nutritionpoint.database.SleepDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SleepTrackerActivity : AppCompatActivity() {
    private lateinit var sleepDataDao: SleepDataDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sleep_tracker)

        val db = SleepDatabase.getDatabase(applicationContext)
        sleepDataDao = db.sleepDataDao()

        val sleepQualitySeekBar: SeekBar = findViewById(R.id.sleep_quality_seekbar)

        findViewById<Button>(R.id.save_sleep_button).setOnClickListener {
            val startTime = System.currentTimeMillis()
            val endTime = startTime + 8 * 60 * 60 * 1000 // Sleep for 8 hours
            val sleepQuality = sleepQualitySeekBar.progress

            val sleepData = SleepData(startTime = startTime, endTime = endTime, quality = sleepQuality)
            GlobalScope.launch {
                sleepDataDao.insertSleepData(sleepData)
            }
        }
    }
}
