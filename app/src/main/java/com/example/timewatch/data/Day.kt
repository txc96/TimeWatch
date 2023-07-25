package com.example.timewatch.data;

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
enum class MoodValue {
    GOOD, AVERAGE, BAD, NONE
}

@Entity
data class Day (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "mood") val mood: MoodValue,
    @ColumnInfo(name = "notes") val notes: String?,
    @ColumnInfo(name = "vacation") val vacation: Boolean,
    @ColumnInfo(name = "records") val records: List<Record>
)
