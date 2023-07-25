package com.example.timewatch.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Day::class, Record::class, Tag::class], version = 1)
abstract class mDatabase : RoomDatabase() {
    abstract fun userDao(): DayDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: mDatabase? = null

        fun getDatabase(context: Context): mDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    mDatabase::class.java,
                    "mDatabase"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}