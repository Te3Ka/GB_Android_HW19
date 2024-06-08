package ru.te3ka.homework19.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.te3ka.homework19.model.Landmark

@Dao
interface LandmarkDao {
    @Insert
    suspend fun insert(landmark: Landmark)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(landmarks: List<Landmark>)

    @Query("SELECT * FROM landmarks")
    fun getAllLandmarksLiveData(): LiveData<List<Landmark>>
}