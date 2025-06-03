package com.example.hacktrophy.data

data class TopTeamsResponse(
    val year: String,
    val teams: List<Team>
) {
    data class Team(
        val team_id: Int,
        val team_name: String,
        val points: Float
    )
}
