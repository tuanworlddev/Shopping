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
import com.git.shopping.ui.screens.auth.AuthViewModel
import com.git.shopping.ui.screens.cart.CardScreen
import com.git.shopping.ui.screens.category.CategoryViewModel
import com.git.shopping.ui.screens.category.create.CreateCategoryScreen
import com.git.shopping.ui.screens.home.HomeScreen
import com.git.shopping.ui.screens.auth.login.LoginScreen
import com.git.shopping.ui.screens.notification.NotificationScreen
import com.git.shopping.ui.screens.order.OrderScreen
import com.git.shopping.ui.screens.profile.ProfileScreen
import com.git.shopping.ui.screens.auth.register.RegisterScreen
import com.git.shopping.ui.screens.category.detail.CategoryDetailsScreen
import com.git.shopping.ui.screens.firebase.UploadViewModel
import com.git.shopping.ui.screens.product.ProductViewModel
import com.git.shopping.ui.screens.product.create.CreateProductScreen
import com.git.shopping.ui.screens.product.detail.ProductDetailsScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    paddingValues: PaddingValues,
    context: Context,
    categoryViewModel: CategoryViewModel,
    authViewModel: AuthViewModel,
    uploadViewModel: UploadViewModel,
    productViewModel: ProductViewModel
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route,
        modifier = Modifier.padding(paddingValues = paddingValues)
    ) {
        composable("home") {
            HomeScreen(
                categoryViewModel = categoryViewModel,
                productViewModel = productViewModel,
                navController = navHostController
            )
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
        composable("product_detail/{productId}") {backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            productId?.let { ProductDetailsScreen(it, productViewModel = productViewModel) }
        }
        composable("create_product") {
            CreateProductScreen()
        }
        composable("categories") {

        }
        composable("create_category") {
            CreateCategoryScreen(
                context = context,
                categoryViewModel = categoryViewModel,
                uploadViewModel = uploadViewModel
            )
        }
        composable("category_detail/{categoryId}") {
            val categoryName = it.arguments?.getString("categoryId")
            categoryName?.let { CategoryDetailsScreen(categoryName = categoryName, productViewModel = productViewModel, navController = navHostController) }
        }
        composable("login") {
            LoginScreen(context = context, navController = navHostController, authViewModel = authViewModel)
        }
        composable("register") {
            RegisterScreen(context = context, navController = navHostController, authViewModel = authViewModel)
        }
        composable("profile") {
            ProfileScreen(navController = navHostController, authViewModel = authViewModel)
        }
    }
}