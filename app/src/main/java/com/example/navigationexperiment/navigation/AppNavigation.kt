package com.example.navigationexperiment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationexperiment.ui.CheckoutScreen
import com.example.navigationexperiment.ui.HomeScreen
import com.example.navigationexperiment.ui.ProductDetailScreen

@Composable
fun AppNavigation() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Routes.HomeScreen) {
        composable(Routes.HomeScreen) {
            HomeScreen(navHostController)
        }
        composable(Routes.ProductScreen) {
            ProductDetailScreen(navHostController)
        }
        composable(Routes.CheckoutScreen) {
            CheckoutScreen(navHostController = navHostController)
        }
    }

}

object Routes {
    const val HomeScreen = "Home"
    const val ProductScreen = "Product"
    const val CheckoutScreen = "Checkout"
}