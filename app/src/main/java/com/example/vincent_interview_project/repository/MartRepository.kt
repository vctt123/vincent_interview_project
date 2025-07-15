package com.example.vincent_interview_project.repository

import com.example.vincent_interview_project.api.MartApi
import com.example.vincent_interview_project.room.dao.MartDao
import com.example.vincent_interview_project.room.entity.MartEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MartRepository @Inject constructor(
    private val api: MartApi,
    private val dao: MartDao
) {
    fun getLocalMarts(): Flow<List<MartEntity>> = dao.getAll()

    suspend fun fetchAndCacheMarts() {
        val marts = api.getMarts()
        dao.insertAll(marts.map { MartEntity.from(it) })
    }
}