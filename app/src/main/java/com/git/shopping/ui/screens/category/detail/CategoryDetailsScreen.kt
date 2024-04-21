package com.git.shopping.ui.screens.category.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.git.shopping.models.Product
import com.git.shopping.ui.components.CardCloth
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.screens.product.ProductViewModel
import com.git.shopping.ui.screens.product.detail.ProductDetails
import kotlinx.coroutines.launch

@Composable
fun CategoryDetailsScreen(
    categoryName: String,
    productViewModel: ProductViewModel,
    navController: NavController
) {
    val allProducts by productViewModel.getAllProducts().observeAsState(emptyList())
    val products = allProducts.filter { it.category == categoryName }

    Surface(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Text(
            text = categoryName,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            color = Color.Black
        )
        SpacerHeight(int = 10)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(products) { product ->
                CardCloth(product, navController)
            }
        }
    }
}