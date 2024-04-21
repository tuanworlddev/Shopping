package com.git.shopping.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.git.shopping.R
import com.git.shopping.models.Category
import com.git.shopping.models.Product
import com.git.shopping.ui.screens.category.CategoryViewModel
import com.git.shopping.ui.screens.product.ProductViewModel
import com.git.shopping.ui.theme.circularFont

@Composable
fun Categories(
    categoryViewModel: CategoryViewModel,
    navController: NavController
) {
    val categories by categoryViewModel.getAllCategories().observeAsState(emptyList())

    Surface(
        modifier = Modifier.padding(20.dp)
    ) {
        LazyRow {
            items(categories) { category ->
                CategoryItem(category = category, navController = navController)
                SpacerWidth(int = 10)
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            navController.navigate("category_detail/${category.name}")
        }
    ) {
        Image(painter = rememberAsyncImagePainter(model = category.image),
            contentDescription = null, modifier = Modifier.size(56.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = category.name, fontFamily = circularFont, style = TextStyle(fontSize = 11.sp),
            fontWeight = FontWeight(100)
        )
    }
}

@Composable
fun ListCard(products: List<Product>, title: String, navController: NavController) {
    TitleCloth(title = title)
    Spacer(modifier = Modifier.height(16.dp))
    Surface {
        LazyRow {
            items(products) { product ->
                CardCloth(product, navController)
            }
        }
    }
}