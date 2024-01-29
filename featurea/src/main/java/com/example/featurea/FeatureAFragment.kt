package com.example.featurea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.core.FeatureScreenBRouteContract
import com.example.featurea.databinding.FragmentFeatureABinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class FeatureAFragment : Fragment() {
    private lateinit var binding: FragmentFeatureABinding

    @Inject
    lateinit var featureScreenBRouteContract: FeatureScreenBRouteContract

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeatureABinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("the passed data to fragment a is ${FeatureAFragmentArgs.fromBundle(requireArguments()).argAValue}")
        binding.buttonOpenFeatureScreenB.setOnClickListener {
            featureScreenBRouteContract.show("as", findNavController())
        }

    }

}