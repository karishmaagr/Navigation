package com.example.core

import androidx.navigation.NavController

interface FeatureScreenBRouteContract {
    fun show(dataToPass: String, navController: NavController)
}