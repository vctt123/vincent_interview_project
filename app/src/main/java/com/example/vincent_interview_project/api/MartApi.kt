package com.example.vincent_interview_project.api

import com.example.vincent_interview_project.data.Mart
import retrofit2.http.GET

interface MartApi {
    @GET("app/test/marttest.json")
    suspend fun getMarts(): List<Mart>
}