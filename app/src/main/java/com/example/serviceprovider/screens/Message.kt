package com.example.serviceprovider.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme


@Composable
fun MessageScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background), // Use the theme's background color
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Welcome to Chats Screen",
            color = MaterialTheme.colorScheme.onBackground // Use the theme's text color
        )
    }
}
