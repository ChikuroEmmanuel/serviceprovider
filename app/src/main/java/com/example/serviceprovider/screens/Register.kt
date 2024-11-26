package com.example.serviceprovider.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.google.firebase.database.FirebaseDatabase
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.TextButton






@Composable
fun RegisterScreen(onRegisterSuccess: () -> Unit) {
    // Firebase reference
    val database = FirebaseDatabase.getInstance().reference

    // State variables
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var userType by remember { mutableStateOf("Customer") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header Text
        Text(text = "Create your account", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // First Name and Last Name Fields
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Phone Number Field
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone Number") },
            leadingIcon = { Text("+254") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Gender Selection
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("Male", "Female", "Others").forEach { option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = gender == option, onClick = { gender = option })
                    Text(text = option)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // City Dropdown (TextField for simplicity; replace with actual dropdown if needed)
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Select City") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // User Type Selection
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            listOf("Customer", "Service Provider").forEach { type ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = userType == type, onClick = { userType = type })
                    Text(text = type)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Password and Confirm Password Fields
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit Button
        Button(
            onClick = {
                if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() &&
                    phoneNumber.isNotEmpty() && password.isNotEmpty() && password == confirmPassword
                ) {
                    val user = mapOf(
                        "firstName" to firstName,
                        "lastName" to lastName,
                        "email" to email,
                        "phoneNumber" to phoneNumber,
                        "gender" to gender,
                        "city" to city,
                        "userType" to userType,
                        "password" to password // Consider encrypting the password
                    )
                    database.child("users").push().setValue(user).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            onRegisterSuccess()
                        } else {
                            // Handle error
                        }
                    }
                } else {
                    // Show validation error (optional)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Login Link
        TextButton(onClick = { /* Navigate to Login Screen */ }) {
            Text("Already have an Account? Login")
        }
    }
}
