package com.example.navigationexperiment.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationexperiment.R
import com.example.navigationexperiment.databinding.FragmentHomeBinding
import com.example.navigationexperiment.theme.NavigationAppTheme
import com.example.navigationexperiment.ui.fragmentFlow.HomeScreenFragment

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.layout.setContent {
            NavigationAppTheme {
                HomeScreenFragment() {
                    binding.layout.findNavController().navigate(R.id.action_home_to_detail)
                }
            }
        }
        return binding.root
    }
}