package com.example.hacktrophy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hacktrophy.databinding.HomepageFragmentBinding

class HomepageFragment : Fragment() {

    private var _binding: HomepageFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = HomepageFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonApi.setOnClickListener {
            findNavController().navigate(R.id.action_Main_to_Api)
        }

        binding.buttonDocumentation.setOnClickListener {
            findNavController().navigate(R.id.action_Main_to_Documentation)
        }
        binding.buttonCarbo.setOnClickListener {
            findNavController().navigate(R.id.action_Main_to_Carbo)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}