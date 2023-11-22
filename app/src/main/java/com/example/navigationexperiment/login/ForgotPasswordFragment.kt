package com.example.navigationexperiment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationexperiment.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private var email: String? = null
    private lateinit var binding: FragmentForgotPasswordBinding

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