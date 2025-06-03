package com.example.hacktrophy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hacktrophy.databinding.CarboBinding
import android.content.Intent
import android.net.Uri

class Carbo : Fragment() {

    private var _binding: CarboBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = CarboBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.githubCard.setOnClickListener {
            val githubUrl = "https://github.com/C4rbo"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}