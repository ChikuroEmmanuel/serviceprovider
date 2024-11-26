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
import com.example.serviceprovider.screens.LoginScreen
import com.example.serviceprovider.screens.RegisterScreen
import androidx.navigation.navDeepLink


@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login" // Start with the Login screen
    ) {
        // Login screen destination
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    // Navigate to the home screen after successful login
                    navController.navigate("home") {
                        // Clear the back stack so the user cannot go back to the Login screen
                        popUpTo("login") { inclusive = true }
                    }
                },
                onRegisterClick = {
                    // Navigate to the register screen
                    navController.navigate("register")
                }
            )
        }

        // Register screen destination
        composable("register") {
            RegisterScreen(onRegisterSuccess = {
                // Navigate back to Login after successful registration
                navController.popBackStack()
            })
        }

        // Home screen destination
        composable("home") {
            HomeScreen()
        }

        // Other destinations
        composable("message") { MessageScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
    }
}
