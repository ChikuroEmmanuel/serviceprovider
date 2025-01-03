package com.example.serviceprovider.models

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.clickable
import androidx.navigation.NavController





@Composable
fun ServiceProviderGrid(navController: NavController) {
    val serviceProviders = listOf(
        ServiceProvider("Plumbing", Icons.Default.Build),
        ServiceProvider("Electricians", Icons.Default.Bolt),
        ServiceProvider("Mechanics", Icons.Default.Handyman),
        ServiceProvider("Phone Repairs", Icons.Default.Phone),
        ServiceProvider("Cleaning", Icons.Default.CleaningServices),
        ServiceProvider("Painting", Icons.Default.Brush)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(serviceProviders) { serviceProvider ->
            ServiceCard(serviceProvider, onClick = { serviceName ->
                // Navigate to the provider details screen with the service name
                navController.navigate("provider_details/$serviceName")
            })
        }
    }
}


@Composable
fun ServiceCard(serviceProvider: ServiceProvider, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clickable { onClick(serviceProvider.name) }, // Navigate on click
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = serviceProvider.icon,
                contentDescription = serviceProvider.name,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = serviceProvider.name,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}




data class ServiceProvider(
    val name: String,
    val icon: ImageVector
)
