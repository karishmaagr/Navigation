package com.example.navigationexperiment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NavigationApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}