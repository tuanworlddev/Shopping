package com.git.shopping.ui.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.git.shopping.R
import com.git.shopping.constants.Screen
import com.git.shopping.ui.components.SpacerHeight

@Composable
fun ProfileScreen(
    navController: NavController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column {
            Button(
                onClick = { navController.navigate(Screen.LoginScreen.route) }
            ) {
                Text(text = stringResource(id = R.string.login))
            }
            SpacerHeight(height = 10)
            Button(onClick = { navController.navigate(Screen.RegisterScreen.route) }) {
                Text(text = stringResource(id = R.string.register))
            }
            SpacerHeight(height = 10)
            Button(onClick = { navController.navigate(Screen.CreateProductScreen.route) }) {
                Text(text = stringResource(id = R.string.create_product))
            }
            SpacerHeight(height = 10)
            Button(onClick = { navController.navigate(Screen.CreateCategoryScreen.route) }) {
                Text(text = stringResource(id = R.string.create_category))
            }
            SpacerHeight(height = 10)
        }
    }
}