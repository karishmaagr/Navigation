// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.7.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")

    }
}
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}