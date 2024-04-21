package com.git.shopping.ui.screens.product.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.git.shopping.models.Product
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.screens.product.ProductViewModel
import com.git.shopping.ui.theme.Black50
import kotlinx.coroutines.launch

@Composable
fun ProductDetailsScreen(
    productId: String,
    productViewModel: ProductViewModel
) {
    val coroutineScope = rememberCoroutineScope()
    var product by remember { mutableStateOf<Product?>(null) }

    LaunchedEffect(productId) {
        productViewModel.getProduct(productId) { result ->
            coroutineScope.launch {
                product = result
            }
        }
    }

    ProductDetails(product = product)
}

@Composable
fun ProductDetails(product: Product?) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        if (product != null) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(painter = rememberAsyncImagePainter(model = product.image), contentDescription = product.name)
                }
                SpacerHeight(int = 20)
                Text(
                    text = product.name,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    color = Color.Black
                )
                SpacerHeight(int = 10)
                if (product.sale > 0) {
                    Text(
                        text = "$${product.price * product.sale / 100}",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = Color.Red
                    )
                    SpacerHeight(int = 5)
                    Text(
                        text = "$${product.price}",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = Black50,
                        textDecoration = TextDecoration.LineThrough
                    )
                } else {
                    Text(
                        text = "$${product.price}",
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        color = Color.Red
                    )
                }
                SpacerHeight(int = 10)
                Text(
                    text = "Description",
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    color = Color.Black
                )
                SpacerHeight(int = 10)
                Text(
                    text = product.description,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    color = Color.Black
                )
                SpacerHeight(int = 40)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {  },
                    ) {
                        Text(text = "Add Card")
                    }
                    Button(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(text = "Order")
                    }
                }
            }
        }
    }
}