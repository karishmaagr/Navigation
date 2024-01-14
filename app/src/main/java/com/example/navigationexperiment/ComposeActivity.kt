package com.example.navigationexperiment

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.core.FeatureScreenARouteContract
import com.example.navigationexperiment.navigation.AppNavigation
import com.example.navigationexperiment.theme.NavigationAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {

    @Inject
    lateinit var featureScreenARouteContract: FeatureScreenARouteContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window?.decorView?.systemUiVisibility =
                (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.statusBarColor = android.graphics.Color.TRANSPARENT
            NavigationAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    AppNavigation(featureScreenARouteContract)
                }
            }
        }
    }
}
