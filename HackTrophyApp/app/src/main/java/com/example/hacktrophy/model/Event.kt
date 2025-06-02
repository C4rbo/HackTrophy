package com.example.hacktrophy.model

data class Event(
    val id: Int,
    val title: String,
    val description: String?,
    val url: String?,
    val format: String?,
    val restrictions: String?,
    val start: String,
    val finish: String,
    val duration: Duration?,
    val organizers: List<Organizer>?
)

data class Duration(
    val days: Int?,
    val hours: Int?
)

data class Organizer(
    val id: Int,
    val name: String
)
