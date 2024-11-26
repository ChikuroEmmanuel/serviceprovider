package com.example.serviceprovider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.navigation.compose.rememberNavController
import com.example.serviceprovider.ui.theme.ServiceProviderTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.serviceprovider.Navigation.AppNavHost
import com.example.serviceprovider.Navigation.BottomNavigationBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.serviceprovider.screens.LoginScreen
import com.example.serviceprovider.screens.HomeScreen
import androidx.navigation.compose.currentBackStackEntryAsState








class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Handle the splash screen transition
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ServiceProviderTheme {
                MainScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Get the current backstack entry to determine the current route
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentDestination != "login" && currentDestination != "register") {
                // Show TopAppBar only after logging in
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = { Text("Jiji") }
                )
            }
        },
        bottomBar = {
            if (currentDestination != "login" && currentDestination != "register") {
                // Show BottomNavigationBar only after logging in
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            // Use AppNavHost for all navigation logic
            AppNavHost(navController = navController)
        }
    }
}

