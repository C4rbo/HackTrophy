package com.example.hacktrophy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hacktrophy.databinding.CarboBinding
import android.content.Intent
import androidx.core.net.toUri

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
            val url = "https://github.com/C4rbo"
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(intent)
        }
        binding.linkedinCard.setOnClickListener {
            val url = "https://www.linkedin.com/in/alessio-carbonara/"
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(intent)
        }
        binding.websiteCard.setOnClickListener {
            val url = "https://c4rbo.vercel.app/"
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}