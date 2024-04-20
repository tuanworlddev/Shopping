package com.git.shopping.ui.screens.auth.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.git.shopping.R
import com.git.shopping.constants.Screen
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.theme.Black50
import com.git.shopping.ui.theme.Light2
import com.git.shopping.ui.theme.circularFont

@Composable
fun LoginScreen(
    context: Context,
    navController: NavController,
    onLogin: (String, String) -> Boolean
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp)
                )
            }
            SpacerHeight(height = 20)
            val placeholderStyle = TextStyle.Default.copy(fontWeight = FontWeight.Light, fontFamily = circularFont, color = Black50)
            Row {
                Surface(
                    color = Light2,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 15.dp),
                            placeholder = { Text(text = "Enter email", style = placeholderStyle) },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Black50
                            )
                        )
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 15.dp),
                            placeholder = { Text(text = "Enter password", style = placeholderStyle) },
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Black50
                            )
                        )
                    }
                }
            }
            SpacerHeight(height = 20)
            Surface(
                modifier = Modifier.padding(10.dp)
            ) {
                Button(
                    onClick = {
                        if (email.isBlank()) {
                            Toast.makeText(context, "Email is required", Toast.LENGTH_SHORT).show()
                        } else if (!isEmailValid(email)) {
                            Toast.makeText(context, "Invalid email format", Toast.LENGTH_SHORT).show()
                        } else if (password.length < 6) {
                            Toast.makeText(context, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
                        } else {
                            if (onLogin(email, password)) {
                                Toast.makeText(context, "Login successfully", Toast.LENGTH_SHORT).show()
                                navController.navigate(Screen.HomeScreen.route)
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.login))
                }
            }
        }
    }
}

private fun isEmailValid(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}