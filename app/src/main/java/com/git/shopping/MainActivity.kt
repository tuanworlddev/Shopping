package com.git.shopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.git.shopping.navigation.NavGraph
import com.git.shopping.ui.components.BottomBar
import com.git.shopping.ui.components.TopBar
import com.git.shopping.ui.screens.auth.AuthViewModel
import com.git.shopping.ui.screens.category.CategoryViewModel
import com.git.shopping.ui.theme.ShoppingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                val categoryViewModel by viewModels<CategoryViewModel>()
                val authViewModel by viewModels<AuthViewModel>()
                Scaffold(
                    topBar = {
                        TopBar()
                    },
                    bottomBar = {
                        BottomBar(navController)
                    },
                    content = { paddingValues ->
                        NavGraph(
                            navHostController = navController,
                            paddingValues = paddingValues,
                            context = context,
                            categoryViewModel = categoryViewModel,
                            authViewModel = authViewModel
                        )
                    }
                )
            }
        }
    }
}
