package com.example.hacktrophy.network

import com.example.hacktrophy.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CtftimeApi {
    @GET("top/")
    fun getTopTeams(@Query("limit") limit: Int = 10): Call<Map<String, List<Team>>>

    @GET("events/")
    fun getEvents(
        @Query("limit") limit: Int,
        @Query("start") start: Long,
        @Query("finish") finish: Long
    ): Call<List<Event>>

}
