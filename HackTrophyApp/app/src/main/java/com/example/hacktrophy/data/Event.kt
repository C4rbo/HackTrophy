package com.example.hacktrophy.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val url: String,
    val ctftime_url: String,
    val logo: String,
    val format: String,
    val restrictions: String,
    val start: String,
    val finish: String,
    val duration: Duration,
    val location: String,
    val organizers: List<Organizer>,
    val weight: Double,
    val participants: Int,
    val format_id: Int,
    val onsite: Boolean
) : Parcelable

@Parcelize
data class Organizer(
    val id: Int,
    val name: String
) : Parcelable

@Parcelize
data class Duration(
    val days: Int,
    val hours: Int
) : Parcelable