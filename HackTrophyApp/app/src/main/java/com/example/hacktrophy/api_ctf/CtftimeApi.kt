package com.example.hacktrophy.api_ctf

import com.example.hacktrophy.data.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CtftimeApi {
    @GET("top/")
    fun getTopTeams(): Call<Map<String, List<Team>>>

    @GET("events/")
    fun getEvents(
        @Query("limit") limit: Int,
        @Query("start") start: Long,
        @Query("finish") finish: Long
    ): Call<List<Event>>

}
