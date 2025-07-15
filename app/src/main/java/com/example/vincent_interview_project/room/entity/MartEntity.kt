package com.example.vincent_interview_project.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.vincent_interview_project.data.Mart

@Entity(tableName = "mart")
data class MartEntity(
    @PrimaryKey val martId: String,
    val martName: String,
    val logoUrl: String
) {
    companion object {
        fun from(mart: Mart) = MartEntity(mart.martId, mart.martName, mart.logoUrl)
    }
}