package com.example.navigationexperiment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.core.FeatureScreenARouteContract
import com.example.navigationexperiment.databinding.FragmentForgotPasswordBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ForgotPasswordFragment : Fragment() {
    private var email: String? = null
    private lateinit var binding: FragmentForgotPasswordBinding

    @Inject
    lateinit var featureScreenARouteContract: FeatureScreenARouteContract
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            email = it.getString("email")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = "Forgot password $email"
        binding.text.setOnClickListener {
            featureScreenARouteContract.show("passing from fp",findNavController())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(email: String) =
            ForgotPasswordFragment().apply {
                arguments = Bundle().apply {
                    putString("email", email)
                }
            }
    }
}