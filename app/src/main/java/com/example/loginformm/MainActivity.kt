package com.example.loginformm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardOptions
//import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginformm.ui.theme.LoginformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginformTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    // State variables for user input
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) } // Password visibility toggle

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Login",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Email Text Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            //keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email Icon") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Text Field with Visibility Toggle
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            //keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock Icon") },
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                val description = if (passwordVisible) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit Button
        Button(
            onClick = { /* No action required as per instructions */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginformTheme {
        LoginScreen()
    }
}
