package com.example.timewatch.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TagRepository (private val tagDao: TagDao) {
    val allTags: Flow<List<Tag>> = tagDao.getAll()

    suspend fun getTagByID(id: Int): Tag{
        return tagDao.findByID(id)
    }

    @WorkerThread
    suspend fun insert(tag: Tag) {
        tagDao.insert(tag)
    }
}