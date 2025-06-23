package com.example.hacktrophy.adaptercustom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hacktrophy.databinding.ItemUpcomingEventBinding
import com.example.hacktrophy.data.Event
import java.text.SimpleDateFormat
import java.util.*

class UpcomingEventsAdapter(
    private val events: List<Event>,
    private val onEventClick: (Event) -> Unit
) : RecyclerView.Adapter<UpcomingEventsAdapter.EventViewHolder>() {

    inner class EventViewHolder(private val binding: ItemUpcomingEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.eventTitle.text = event.title
            binding.eventTime.text = "${formatIsoDate(event.start)} → ${formatIsoDate(event.finish)}"
            itemView.setOnClickListener {
                onEventClick(event)
            }
        }

        private fun formatIsoDate(isoString: String): String {
            return try {
                val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
                val date = parser.parse(isoString)
                val formatter = SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault())
                formatter.format(date!!)
            } catch (e: Exception) {
                isoString
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemUpcomingEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }
}