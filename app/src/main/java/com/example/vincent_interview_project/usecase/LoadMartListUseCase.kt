package com.example.vincent_interview_project.usecase

import com.example.vincent_interview_project.repository.MartRepository
import com.example.vincent_interview_project.room.entity.MartEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadMartListUseCase @Inject constructor(private val repo: MartRepository) {
    operator fun invoke(): Flow<List<MartEntity>> = repo.getLocalMarts()
    suspend fun refresh() = repo.fetchAndCacheMarts()
}