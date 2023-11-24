package com.example.navigationexperiment.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationexperiment.databinding.FragmentCheckoutBinding
import com.example.navigationexperiment.theme.NavigationAppTheme
import com.example.navigationexperiment.ui.fragmentFlow.CheckoutScreenFragment
import com.example.navigationexperiment.ui.fragmentFlow.HomeScreenFragment

class CheckoutFragment : Fragment() {
    private lateinit var binding: FragmentCheckoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        binding.layout.setContent {
            NavigationAppTheme {
                CheckoutScreenFragment() {

                }
            }
        }
        return binding.root
    }
}