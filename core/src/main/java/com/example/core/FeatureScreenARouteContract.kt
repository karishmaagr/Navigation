package com.example.core

import androidx.navigation.NavController

interface FeatureScreenARouteContract {
    fun show(dataToPass: String, navController: NavController)
}