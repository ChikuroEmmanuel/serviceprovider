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



@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp), // Add padding for spacing
        contentAlignment = Alignment.TopCenter // Align content to the top
    ) {
        // Service Provider Grid
        ServiceProviderGrid()
    }
}

