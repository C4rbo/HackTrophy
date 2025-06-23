package com.example.hacktrophy.adaptercustom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hacktrophy.data.Organizer
import com.example.hacktrophy.databinding.ItemOrganizerBinding

class OrganizerAdapter(private val organizers: List<Organizer>) :
    RecyclerView.Adapter<OrganizerAdapter.OrganizerViewHolder>() {

    inner class OrganizerViewHolder(private val binding: ItemOrganizerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(organizer: Organizer) {
            binding.organizerName.text = organizer.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizerViewHolder {
        val binding = ItemOrganizerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrganizerViewHolder(binding)
    }

    override fun getItemCount(): Int = organizers.size

    override fun onBindViewHolder(holder: OrganizerViewHolder, position: Int) {
        holder.bind(organizers[position])
    }
}