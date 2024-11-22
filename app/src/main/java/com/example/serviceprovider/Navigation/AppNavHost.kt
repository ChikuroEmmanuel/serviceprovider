package com.example.serviceprovider.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.serviceprovider.screens.MessageScreen
import com.example.serviceprovider.screens.HomeScreen
import com.example.serviceprovider.screens.ProfileScreen
import com.example.serviceprovider.screens.SettingsScreen
@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        // Add navigation destinations
        composable("home") { HomeScreen() }
        composable("message") { MessageScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
    }
}
