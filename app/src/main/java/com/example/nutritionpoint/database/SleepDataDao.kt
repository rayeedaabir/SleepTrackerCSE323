package com.example.nutritionpoint.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SleepDataDao {
    @Insert
    suspend fun insertSleepData(sleepData: com.example.nutritionpoint.database.SleepData.kt)

    @Query("SELECT * FROM sleep_data ORDER BY startTime DESC")
    suspend fun getAllSleepData(): List<com.example.nutritionpoint.database.SleepData.kt>
}
