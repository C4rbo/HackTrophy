package com.example.hacktrophy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hacktrophy.databinding.CtftimeBinding
import com.example.hacktrophy.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.example.hacktrophy.model.Team
import com.example.hacktrophy.model.Event

class Ctftime : Fragment() {

    private var _binding: CtftimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CtftimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTopTeamsWorld.setOnClickListener { loadTopTeams() }
        binding.btnUpcomingEvents.setOnClickListener { loadUpcomingEvents() }

    }

    private fun loadTopTeams() {
        RetrofitInstance.api.getTopTeams().enqueue(object : Callback<Map<String, List<Team>>> {
            override fun onResponse(
                call: Call<Map<String, List<Team>>>,
                response: Response<Map<String, List<Team>>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    val currentYear = data?.keys?.firstOrNull()
                    val teams = currentYear?.let { data[it] }

                    val output = teams?.joinToString("\n") {
                        "${it.team_name} (${it.points.toInt()} pts)"
                    }

                    binding.textView.text = output ?: "Nessun team trovato."
                } else {
                    binding.textView.text = "Errore: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<Map<String, List<Team>>>, t: Throwable) {
                binding.textView.text = "Errore di rete: ${t.localizedMessage}"
            }
        })
    }
    private fun loadUpcomingEvents() {
        val now = System.currentTimeMillis() / 1000
        val in30Days = now + (60 * 60 * 24 * 30)

        RetrofitInstance.api.getEvents(10, now, in30Days).enqueue(object : Callback<List<Event>> {
            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if (response.isSuccessful) {
                    val events = response.body()
                    val output = events?.joinToString("\n\n") {
                        "${it.title}\n${it.start} → ${it.finish}"
                    }
                    binding.textView.text = output ?: "Nessun evento futuro"
                } else {
                    binding.textView.text = "Errore eventi: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                binding.textView.text = "Errore rete: ${t.localizedMessage}"
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
