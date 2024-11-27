package com.example.serviceprovider.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.example.serviceprovider.models.ServiceProviderGrid
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember





@Composable
fun HomeScreen(navController: NavController) {
    val serviceProviders = remember { mutableStateOf<List<String>>(emptyList()) }

    // Fetch providers based on selected service
    fun fetchProviders(serviceName: String) {
        fetchServiceProviders(serviceName) { providers ->
            serviceProviders.value = providers
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        // Service Provider Grid
        ServiceProviderGrid(navController)
    }
}

