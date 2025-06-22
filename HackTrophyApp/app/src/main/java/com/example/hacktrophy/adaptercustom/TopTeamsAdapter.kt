package com.example.hacktrophy.adaptercustom

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hacktrophy.databinding.ItemTopTeamBinding
import com.example.hacktrophy.data.Team

class TopTeamsAdapter(private val teams: List<Team>) :
    RecyclerView.Adapter<TopTeamsAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(private val binding: ItemTopTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team, position: Int) {
            binding.teamPosition.text = (position + 1).toString()
            binding.teamName.text = team.team_name
            binding.teamPoints.text = "${team.points} pts"


            binding.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ctftime.org/team/${team.team_id}"))
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTopTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teams[position], position)
    }

    override fun getItemCount(): Int = teams.size
}