package com.example.serviceprovider.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Message
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    object Message : BottomNavItem("message", "Message", Icons.Filled.Message)
    object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
    object Settings : BottomNavItem("settings", "Settings", Icons.Default.Settings)
}
