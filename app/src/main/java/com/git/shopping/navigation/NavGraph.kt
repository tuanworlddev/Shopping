package com.git.shopping.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.git.shopping.constants.Screen
import com.git.shopping.ui.screens.card.CardScreen
import com.git.shopping.ui.screens.category.create.CreateCategoryScreen
import com.git.shopping.ui.screens.home.HomeScreen
import com.git.shopping.ui.screens.login.LoginScreen
import com.git.shopping.ui.screens.notification.NotificationScreen
import com.git.shopping.ui.screens.order.OrderScreen
import com.git.shopping.ui.screens.profile.ProfileScreen
import com.git.shopping.ui.screens.register.CreateAccount


@Composable
fun NavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        composable("home") {
            HomeScreen()
        }
        composable("card") {
            CardScreen()
        }
        composable("notification") {
            NotificationScreen()
        }
        composable("order") {
            OrderScreen()
        }
        composable("product_detail") {

        }
        composable("create_product") {

        }
        composable("categories") {

        }
        composable("create_category") {
            CreateCategoryScreen()
        }
        composable("category_detail") {

        }
        composable("login") {
            LoginScreen()
        }
        composable("register") {
            CreateAccount()
        }
        composable("profile") {
            ProfileScreen(navController = navHostController)
        }
    }
}