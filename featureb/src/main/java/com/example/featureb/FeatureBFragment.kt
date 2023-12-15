package com.example.featureb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.core.FeatureScreenARouteContract
import com.example.featureb.databinding.FragmentFeatureBBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FeatureBFragment : Fragment() {
    private lateinit var binding: FragmentFeatureBBinding

    @Inject
    lateinit var featureScreenARouteContract: FeatureScreenARouteContract

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFeatureBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("the passed data to fragment b is ${FeatureBFragmentArgs.fromBundle(requireArguments()).argBValue}")
        binding.buttonOpenFeatureScreenA.setOnClickListener {
            featureScreenARouteContract.show("asa", findNavController())
        }
    }

}