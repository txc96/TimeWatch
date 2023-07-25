package com.example.timewatch.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class RecordRepository (private val recordDao: RecordDao) {
    val allRecords: Flow<List<Record>> = recordDao.getAll()

    suspend fun getDateByID(id: Int): Record{
        return recordDao.findByID(id)
    }

    suspend fun getRecordsByDate(date: String): List<Record>{
        return recordDao.findByRecordsByDate(date)
    }

    @WorkerThread
    suspend fun insert(record: Record) {
        recordDao.insert(record)
    }
}