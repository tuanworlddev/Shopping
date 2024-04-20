package com.git.shopping.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.git.shopping.constants.NavItems
import com.git.shopping.constants.Screen
import com.git.shopping.ui.theme.Light1
import com.git.shopping.ui.theme.Primary100

@Composable
fun BottomBar(
    navController: NavController
) {
    var selectedRoute by remember {
        mutableStateOf(Screen.HomeScreen.route)
    }
    NavigationBar(
        containerColor = Light1,
        contentColor = Light1
    ) {
        NavItems.bottomNavItems.forEach { navItem ->
            NavigationBarItem(
                selected = selectedRoute == navItem.route,
                onClick = {
                    selectedRoute = navItem.route
                    navController.navigate(navItem.route)
                },
                icon = { 
                    if (selectedRoute == navItem.route) {
                        Icon(
                            imageVector = navItem.icon!!,
                            contentDescription = navItem.title,
                            tint = Primary100
                        )
                    } else {
                        Icon(
                            imageVector = navItem.icon!!,
                            contentDescription = navItem.title,
                            tint = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            )
        }
    }
}