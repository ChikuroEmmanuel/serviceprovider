package com.example.serviceprovider.authfirebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import java.util.concurrent.TimeUnit
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.FirebaseException
import android.app.Activity
import android.content.Context



object FirebaseAuthUtils {
    // Login with email and password
    fun loginWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccess()  // Handle successful login
                } else {
                    onError(task.exception?.message ?: "Login failed")  // Handle login failure
                }
            }
    }

    // Optional: Sign up with email and password (for user registration)
    fun signUpWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onSuccess()  // Handle successful sign-up
                } else {
                    onError(task.exception?.message ?: "Registration failed")  // Handle sign-up failure
                }
            }
    }
}
