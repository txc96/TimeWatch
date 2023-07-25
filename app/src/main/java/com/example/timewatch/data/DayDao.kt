package com.example.timewatch.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DayDao {
    @Query("SELECT * FROM day")
    fun getAll(): Flow<List<Day>>

    @Query("SELECT * FROM day " +
            //"INNER JOIN record ON record.id IN day.records " +
            //TODO Return to this join but for now make it a fetch method instead
            "WHERE id LIKE :dateId LIMIT 1")
    suspend fun findByID(dateId: Int): Day

    //Dates must be in YYYY-MM-DD format
    @Query("SELECT * FROM day WHERE date BETWEEN :dateStart AND :dateEnd")
    suspend fun findByDateRange(dateStart: String, dateEnd: String): List<Day>

    @Query("SELECT * FROM day WHERE date LIKE :date LIMIT 1")
    suspend fun findByDate(date: String): Day

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(day: Day)

    @Delete
    suspend fun delete(day: Day)
}