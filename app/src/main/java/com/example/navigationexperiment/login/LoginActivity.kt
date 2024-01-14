package com.example.navigationexperiment.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navigationexperiment.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}