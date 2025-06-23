package com.example.hacktrophy

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hacktrophy.adaptercustom.OrganizerAdapter
import com.example.hacktrophy.data.Event
import com.example.hacktrophy.databinding.FragmentEventDetailsBinding
import java.text.SimpleDateFormat
import java.util.*

class EventDetailsFragment : Fragment() {
    private var _binding: FragmentEventDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { args ->
            val event = args.getParcelable<Event>("event")
            event?.let { showEventDetails(it) }
        }
    }

    private fun showEventDetails(event: Event) {
        binding.eventTitle.text = event.title
        binding.eventTime.text = "${formatIsoDate(event.start)} → ${formatIsoDate(event.finish)}"

        binding.eventLocation.text = event.location.ifEmpty { "Online" }

        binding.eventFormat.text = "${event.format} (${event.restrictions})"

        binding.organizersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = OrganizerAdapter(event.organizers)
        }

        binding.eventWeight.text = event.weight.toString()
        binding.eventParticipants.text = event.participants.toString()

        if (event.description.isNotEmpty()) {
            binding.eventDescription.text = Html.fromHtml(event.description, Html.FROM_HTML_MODE_COMPACT)
        }

        binding.ctftimeButton.setOnClickListener {
            openUrl(event.ctftime_url)
        }

        binding.eventUrlButton.setOnClickListener {
            openUrl(event.url)
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}