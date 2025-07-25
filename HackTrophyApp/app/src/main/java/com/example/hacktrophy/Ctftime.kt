package com.example.hacktrophy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hacktrophy.databinding.CtftimeBinding

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

        binding.btnTopTeamsWorld.setOnClickListener {
            findNavController().navigate(R.id.action_Api_to_Topteam)
        }
        binding.btnUpcomingEvents.setOnClickListener {
            findNavController().navigate(R.id.action_Api_to_Upcomingevents)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}