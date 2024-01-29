package com.example.navigationexperiment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.FeatureScreenARouteContract
import com.example.navigationexperiment.ui.CheckoutScreen
import com.example.navigationexperiment.ui.HomeScreen
import com.example.navigationexperiment.ui.ProductDetailScreen

@Composable
fun AppNavigation(featureScreenARouteContract: FeatureScreenARouteContract) {

    val navHostController = rememberNavController()

    //Scenario, Navigating from compose view to compose view
    NavHost(navController = navHostController, startDestination = Routes.HomeScreen) {
        composable(Routes.HomeScreen) {
            HomeScreen(navHostController,featureScreenARouteContract)
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