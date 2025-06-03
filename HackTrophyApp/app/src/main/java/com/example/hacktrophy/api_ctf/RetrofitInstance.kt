package com.example.hacktrophy.api_ctf

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: CtftimeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://ctftime.org/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CtftimeApi::class.java)
    }
}
