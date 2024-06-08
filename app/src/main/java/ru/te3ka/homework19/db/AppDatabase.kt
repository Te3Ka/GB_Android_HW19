package ru.te3ka.homework19.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.te3ka.homework19.dao.LandmarkDao
import ru.te3ka.homework19.model.Landmark
import kotlin.concurrent.Volatile

@Database(entities = [Landmark::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun landmarkDao(): LandmarkDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "landmark_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}