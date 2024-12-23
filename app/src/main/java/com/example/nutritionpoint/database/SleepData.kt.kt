package com.example.nutritionpoint.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_data")
data class `SleepData.kt`(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val startTime: Long,
    val endTime: Long,
    val quality: Int // Sleep quality scale (1-5)
)
