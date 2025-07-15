package com.example.vincent_interview_project.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.vincent_interview_project.data.Mart

@Entity(tableName = "mart")
data class MartEntity(
    @PrimaryKey val martId: Int,
    val martName: String,
    val martShortName: String,
    val price: Int,
    val finalPrice: Int,
    val stockAvailable: Int,
    val imageUrl: String
) {
    companion object {
        fun from(mart: Mart) = MartEntity(
            martId = mart.martId,
            martName = mart.martName,
            martShortName = mart.martShortName,
            price = mart.price,
            finalPrice = mart.finalPrice,
            stockAvailable = mart.stockAvailable,
            imageUrl = mart.imageUrl
        )
    }
}