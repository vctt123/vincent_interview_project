package com.example.vincent_interview_project.data

data class MartResponse(
    val data: List<Mart>
)

data class Mart(
    val martId: Int,
    val martName: String,
    val martShortName: String,
    val price: Int,
    val finalPrice: Int,
    val stockAvailable: Int,
    val imageUrl: String
)
