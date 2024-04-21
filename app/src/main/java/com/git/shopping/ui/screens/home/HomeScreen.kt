package com.git.shopping.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.git.shopping.ui.components.Categories
import com.git.shopping.ui.components.Header
import com.git.shopping.ui.components.ListCard
import com.git.shopping.ui.components.SearchBarTop
import com.git.shopping.ui.components.TitleCloth
import com.git.shopping.ui.screens.category.CategoryViewModel
import com.git.shopping.ui.screens.product.ProductViewModel

@Composable
fun HomeScreen(
    categoryViewModel: CategoryViewModel,
    productViewModel: ProductViewModel,
    navController: NavController
) {

    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Header(navController)

        SearchBarTop()

        TitleCloth(title = "Categories")

        Categories(
            categoryViewModel = categoryViewModel,
            navController = navController
        )

        val allProducts by productViewModel.getAllProducts().observeAsState(emptyList())

        val productsSale = allProducts.filter { it.sale > 0 }
        val productsNoSale = allProducts.filter { it.sale <= 0 }

        Column {
            ListCard(productsSale, title = "Top Selling", navController)
            ListCard(productsNoSale, title = "New In", navController)
        }

    }
}



