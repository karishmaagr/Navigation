package com.example.navigationexperiment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationexperiment.R
import com.example.navigationexperiment.databinding.FragmentSplitLoginBinding

class SplitLoginFragment : Fragment() {


    private lateinit var binding: FragmentSplitLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    private fun setListener() {

        binding.apply {
            btnForgotPassword.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_forgot_password,
                    bundleOf("email" to email.text.toString())
                )
            }

            btnEmailVerification.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_email_verification,
                    bundleOf("email" to email.text.toString())
                )
            }

            btnSignup.setOnClickListener {
                it.findNavController().navigate(R.id.action_signup)
            }

            btnLogin.setOnClickListener {
                /*it.findNavController().navigate(
                    R.id.dashboard_activity,
                    bundleOf("email" to email.text.toString())
                )*/
                it.findNavController().navigate(R.id.action_compose_nav)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplitLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SplitLoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}