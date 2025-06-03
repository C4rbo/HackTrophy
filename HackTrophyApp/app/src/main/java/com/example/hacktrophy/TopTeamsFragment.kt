package com.example.hacktrophy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hacktrophy.adaptercustom.TopTeamsAdapter
import com.example.hacktrophy.databinding.TopTeamsBinding
import com.example.hacktrophy.data.Team
import com.example.hacktrophy.api_ctf.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopTeamsFragment : Fragment() {

    private var _binding: TopTeamsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = TopTeamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerTopTeams.layoutManager = LinearLayoutManager(requireContext())

        RetrofitInstance.api.getTopTeams().enqueue(object : Callback<Map<String, List<Team>>> {
            override fun onResponse(call: Call<Map<String, List<Team>>>, response: Response<Map<String, List<Team>>>) {
                if (response.isSuccessful) {
                    val teams = response.body()?.values?.firstOrNull() ?: emptyList()
                    binding.recyclerTopTeams.adapter = TopTeamsAdapter(teams)
                } else {
                    // Error Api
                }
            }

            override fun onFailure(call: Call<Map<String, List<Team>>>, t: Throwable) {
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
