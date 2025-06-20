package com.example.hacktrophy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hacktrophy.databinding.IntroFragmentBinding

class IntroFragment : Fragment() {

    private var _binding: IntroFragmentBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = IntroFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.card1.setOnClickListener {
            findNavController().navigate(R.id.action_Intro_to_Main)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}