package com.git.shopping.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.git.shopping.R
import com.git.shopping.models.Product
import com.git.shopping.ui.theme.MainGray
import com.git.shopping.ui.theme.MainPurple
import com.git.shopping.ui.theme.circularFont

@Composable
fun ProductCard(product: Product) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.small
            )
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = MaterialTheme.shapes.small
            )
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

@Composable
fun CardCloth(product: Product) {
    Spacer(modifier = Modifier.width(20.dp))
    Column(modifier = Modifier
        .height(281.dp)
        .width(159.dp)) {
        Box() {
            Image(painter = rememberAsyncImagePainter(model = product.image), contentDescription = product.name,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth)
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Spacer(modifier = Modifier.width(120.dp))
                    Icon(painter = painterResource(id = R.drawable.vector), contentDescription = null,
                        modifier = Modifier.size(18.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Men's Harrington Jacket", fontFamily = circularFont,
            style = TextStyle(fontSize = 14.sp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "$148.00", fontFamily = circularFont, style = TextStyle(fontSize = 16.sp),
            fontWeight = FontWeight(700)
        )
    }
}
@Composable
fun CardCloth() {
    Spacer(modifier = Modifier.width(20.dp))
    Column(modifier = Modifier
        .height(281.dp)
        .width(159.dp)) {
        Box() {
            Image(painter = painterResource(id = R.drawable.topselling1), contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth)
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Spacer(modifier = Modifier.width(120.dp))
                    Icon(painter = painterResource(id = R.drawable.vector), contentDescription = null,
                        modifier = Modifier.size(18.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Men's Harrington Jacket", fontFamily = circularFont,
            style = TextStyle(fontSize = 14.sp))
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = "$148.00", fontFamily = circularFont, style = TextStyle(fontSize = 16.sp),
            fontWeight = FontWeight(700)
        )
    }
}

@Composable
fun CategoriesPart() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.categories2),
            contentDescription = null, modifier = Modifier.size(56.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Hoodies", fontFamily = circularFont, style = TextStyle(fontSize = 11.sp),
            fontWeight = FontWeight(100))
    }
}

@Composable
fun Product(product: Product) {
    Row {
        SpacerWidth(int = 20)
        Row(modifier = Modifier
            .height(64.dp)
            .weight(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(color = MainGray), verticalAlignment = Alignment.CenterVertically) {
            SpacerWidth(int = 20)
            Box(modifier = Modifier
                .fillMaxHeight()
                .width(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    color = MainGray
                ), contentAlignment = Alignment.CenterStart){
                Box(modifier = Modifier.size(40.dp)) {
                    androidx.compose.foundation.Image(painter = rememberAsyncImagePainter(model = product.image),
                        contentDescription = product.name, modifier = Modifier.size(40.dp))
                }
            }

            SpacerWidth(int = 20)
            Text(text = "Teddy", fontFamily = circularFont,
                fontWeight = FontWeight(200), fontSize = 14.sp
            )

            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier
                .fillMaxHeight()
                .width(40.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    color = MainGray
                ), contentAlignment = Alignment.CenterStart){
                Box(modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        color = MainPurple
                    ), contentAlignment = Alignment.Center) {
                    androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.minus),
                        contentDescription = null, modifier = Modifier.size(16.dp))
                }

            }
            SpacerWidth(int = 20)

        }
        SpacerWidth(int = 20)
    }

    SpacerHeight(int = 10)
}

@Composable
fun ThemeProduct(product: Product) {
    Row(modifier = Modifier
        .height(80.dp)
        .fillMaxWidth(), ) {
        SpacerWidth(int = 20)
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)) {
            androidx.compose.foundation.Image(painter = rememberAsyncImagePainter(model = product.image),
                contentDescription = product.name, modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center))

        }
        SpacerWidth(int = 20)
    }
}

@Composable
fun ThemeDefaultProduct() {
    Row(modifier = Modifier
        .height(80.dp)
        .fillMaxWidth(), ) {
        SpacerWidth(int = 20)
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)) {
            androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.defaultimage),
                contentDescription = null, modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center))

        }
        SpacerWidth(int = 20)
    }
}

@Composable
fun ThemeProduct() {
    Row(modifier = Modifier
        .height(80.dp)
        .fillMaxWidth(), ) {
        SpacerWidth(int = 20)
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .align(Alignment.CenterVertically)) {
            androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.product),
                contentDescription = null, modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center))

        }
        SpacerWidth(int = 20)
    }
}