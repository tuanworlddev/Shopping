package com.git.shopping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.git.shopping.navigation.NavGraph
import com.git.shopping.ui.components.BottomBar
import com.git.shopping.ui.components.TopBar
import com.git.shopping.ui.screens.dashboarn.DashBoard
import com.git.shopping.ui.screens.home.HomeScreen
import com.git.shopping.ui.screens.login.LoginScreen
import com.git.shopping.ui.theme.ShoppingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopBar()
                    },
                    bottomBar = {
                        BottomBar(navController)
                    },
                    content = { paddingValues ->
                        NavGraph(navHostController = navController, paddingValues = paddingValues)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ShoppingTheme {
        DashBoard()
    }
}
