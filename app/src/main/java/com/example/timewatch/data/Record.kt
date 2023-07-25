package com.example.timewatch.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Record (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "tag") val tag: Int?,
    @ColumnInfo(name = "amount") val amount: Double?,
    @ColumnInfo(name = "date") val date: String?
)
//TODO Create as entity and store uid in Day list
//TODO in Dao, reference Tag id in table