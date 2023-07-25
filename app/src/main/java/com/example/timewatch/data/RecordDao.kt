package com.example.timewatch.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface RecordDao {
    @Query("SELECT * FROM record")
    fun getAll(): Flow<List<Record>>

    @Query("SELECT * FROM record " +
            "INNER JOIN tag ON tag.id = record.tag " +
            "WHERE id LIKE :recordId LIMIT 1")
    suspend fun findByID(recordId: Int): Record

    @Query("SELECT * FROM record " +
            "INNER JOIN tag ON tag.id = record.tag " +
            "WHERE date LIKE :recordDate")
    suspend fun findByRecordsByDate(recordDate: String): List<Record>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(record: Record)

    @Delete
    suspend fun delete(record: Record)
}