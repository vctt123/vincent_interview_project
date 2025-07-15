package com.example.vincent_interview_project.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vincent_interview_project.room.entity.MartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MartDao {
    @Query("SELECT * FROM mart")
    fun getAll(): Flow<List<MartEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<MartEntity>)
}