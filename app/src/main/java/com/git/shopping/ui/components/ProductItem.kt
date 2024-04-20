package com.git.shopping.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.git.shopping.models.Product

@Composable
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background, shape = MaterialTheme.shapes.small)
            .border(1.dp, color = MaterialTheme.colorScheme.secondary, shape = MaterialTheme.shapes.small)
    ) {
        Image(
            painter = rememberAsyncImagePainter(product.image),
            contentDescription = product.name,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = product.name,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = "$${product.price}",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}