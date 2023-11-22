package com.example.navigationexperiment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.navigationexperiment.ARG_PARAM1
import com.example.navigationexperiment.ARG_PARAM2
import com.example.navigationexperiment.R
import com.example.navigationexperiment.databinding.FragmentSplitLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SplitLoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplitLoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentSplitLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
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
                it.findNavController().navigate(
                    R.id.dashboard_activity,
                    bundleOf("email" to email.text.toString())
                )
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SplitLoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SplitLoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}