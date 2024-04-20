package com.git.shopping.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.git.shopping.constants.Screen
import com.git.shopping.models.Category
import com.git.shopping.ui.screens.auth.AuthViewModel
import com.git.shopping.ui.screens.card.CardScreen
import com.git.shopping.ui.screens.category.CategoryViewModel
import com.git.shopping.ui.screens.category.create.CreateCategoryScreen
import com.git.shopping.ui.screens.home.HomeScreen
import com.git.shopping.ui.screens.auth.login.LoginScreen
import com.git.shopping.ui.screens.notification.NotificationScreen
import com.git.shopping.ui.screens.order.OrderScreen
import com.git.shopping.ui.screens.profile.ProfileScreen
import com.git.shopping.ui.screens.auth.register.RegisterScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    context: Context,
    categoryViewModel: CategoryViewModel,
    authViewModel: AuthViewModel
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
            CreateCategoryScreen(
                context = context,
                onCreateCategory = {
                    categoryViewModel.addCategory(Category(id = null, name = it))
                }
            )
        }
        composable("category_detail") {

        }
        composable("login") {
            LoginScreen(context = context, navController = navHostController,onLogin = { email, password ->
                authViewModel.onLogin(email, password)
            })
        }
        composable("register") {
            RegisterScreen(context = context, navController = navHostController, onRegister = { email, password ->
                authViewModel.onRegister(email, password)
            })
        }
        composable("profile") {
            ProfileScreen(navController = navHostController, authViewModel = authViewModel)
        }
    }
}