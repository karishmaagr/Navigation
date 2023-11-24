package com.example.navigationexperiment.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationexperiment.databinding.FragmentProductDetailBinding
import com.example.navigationexperiment.theme.NavigationAppTheme
import com.example.navigationexperiment.ui.fragmentFlow.ProductDetailScreenFragment

class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        binding.layout.setContent {
            NavigationAppTheme {
                ProductDetailScreenFragment(onClick = {

                }, onBack = {

                })
            }
        }
        return binding.root
    }
}