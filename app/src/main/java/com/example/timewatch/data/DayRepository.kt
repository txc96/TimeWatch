package com.example.timewatch.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class DayRepository(private val dayDao: DayDao) {
    val allDays: Flow<List<Day>> = dayDao.getAll()

    suspend fun getDateByID(id: Int): Day{
        return dayDao.findByID(id)
    }

    suspend fun getDatesByRange(dateStart: String, dateEnd: String): List<Day>{
        return dayDao.findByDateRange(dateStart, dateEnd)
    }

    suspend fun getDateByDate(date: String): Day{
        return dayDao.findByDate(date)
    }

    @WorkerThread
    suspend fun insert(day: Day) {
        dayDao.insert(day)
    }
}