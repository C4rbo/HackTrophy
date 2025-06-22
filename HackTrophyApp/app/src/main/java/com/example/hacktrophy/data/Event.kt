package com.example.hacktrophy.data

data class Event(
    val id: Int,
    val title: String,
    val start: String,
    val finish: String
) {
    val url: String
        get() = "https://ctftime.org/event/$id"
}