package com.example.vincent_interview_project.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vincent_interview_project.room.dao.MartDao
import com.example.vincent_interview_project.room.entity.MartEntity

@Database(entities = [MartEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun martDao(): MartDao
}