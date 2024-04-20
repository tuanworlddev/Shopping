package com.git.shopping.constants

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home")
    data object NotificationScreen : Screen("notification")
    data object CartScreen : Screen("card")
    data object OrderScreen : Screen("order")
    data object AccountScreen : Screen("account")
    data object SearchScreen : Screen("search")
    data object LoginScreen : Screen("login")
    data object RegisterScreen : Screen("register")
    data object ForgotPasswordScreen : Screen("forgot_password")
    data object ProfileScreen : Screen("profile")
    data object ProductDetailsScreen : Screen("product_details")
    data object CategoriesScreen : Screen("categories")
    data object CategoryProductsScreen : Screen("category_products")
    data object CreateCategoryScreen : Screen("create_category")
    data object CreateProductScreen : Screen("create_product")
}