package com.example.hacktrophy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hacktrophy.adaptercustom.UpcomingEventsAdapter
import com.example.hacktrophy.databinding.UpcomingEventsBinding
import com.example.hacktrophy.data.Event
import com.example.hacktrophy.api_ctf.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.navigation.fragment.findNavController

class UpcomingEventsFragment : Fragment() {

    private var _binding: UpcomingEventsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UpcomingEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerUpcomingEvents.layoutManager = LinearLayoutManager(requireContext())
        loadUpcomingEvents()
    }

    private fun loadUpcomingEvents() {
        val now = System.currentTimeMillis() / 1000
        val in30Days = now + (60 * 60 * 24 * 30)

        RetrofitInstance.api.getEvents(10, now, in30Days).enqueue(object : Callback<List<Event>> {
            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if (response.isSuccessful) {
                    val events = response.body() ?: emptyList()
                    binding.recyclerUpcomingEvents.adapter = UpcomingEventsAdapter(events) { event ->
                        val action = UpcomingEventsFragmentDirections.actionUpcomingEventsToEventDetails(event)
                        findNavController().navigate(action)
                    }
                } else {
                    // Error
                }
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                // Error Api
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
