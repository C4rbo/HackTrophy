package com.example.hacktrophy.data

data class Team(
    val team_id: Int,
    val team_name: String,
    val points: Float
) {
    val url: String
        get() = "https://ctftime.org/team/$team_id"
}