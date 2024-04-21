package com.git.shopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.git.shopping.navigation.NavGraph
import com.git.shopping.ui.components.BottomBar
import com.git.shopping.ui.components.TopBar
import com.git.shopping.ui.screens.auth.AuthViewModel
import com.git.shopping.ui.screens.category.CategoryViewModel
import com.git.shopping.ui.screens.firebase.UploadViewModel
import com.git.shopping.ui.screens.product.ProductViewModel
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
                val uploadViewModel by viewModels<UploadViewModel>()
                val productViewModel by viewModels<ProductViewModel>()

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
                            authViewModel = authViewModel,
                            uploadViewModel = uploadViewModel,
                            productViewModel = productViewModel
                        )
                    }
                )
            }
        }
    }
}

