package com.git.shopping.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.git.shopping.R
import com.git.shopping.ui.theme.circularFont

@Composable
fun Categories() {
    Spacer(modifier = Modifier.height(16.dp))
    Row {
        Spacer(modifier = Modifier.width(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.categories2),
                contentDescription = null, modifier = Modifier.size(56.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Hoodies", fontFamily = circularFont, style = TextStyle(fontSize = 11.sp),
                fontWeight = FontWeight(100)
            )
        }
        Spacer(modifier = Modifier
            .weight(1f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.categories3),
                contentDescription = null, modifier = Modifier.size(56.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Short", fontFamily = circularFont, style = TextStyle(fontSize = 11.sp),
                fontWeight = FontWeight(100)
            )
        }
        Spacer(modifier = Modifier
            .weight(1f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.categories4),
                contentDescription = null, modifier = Modifier.size(56.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Shoes", fontFamily = circularFont, style = TextStyle(fontSize = 11.sp),
                fontWeight = FontWeight(100)
            )
        }
        Spacer(modifier = Modifier
            .weight(1f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.categories5),
                contentDescription = null, modifier = Modifier.size(56.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Bag", fontFamily = circularFont, style = TextStyle(fontSize = 11.sp),
                fontWeight = FontWeight(100)
            )
        }
        Spacer(modifier = Modifier
            .weight(1f))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.categories1),
                contentDescription = null, modifier = Modifier.size(56.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Accessories", fontFamily = circularFont, style = TextStyle(fontSize = 11.sp),
                fontWeight = FontWeight(100)
            )
        }
        Spacer(modifier = Modifier.width(20.dp))

    }
}

@Composable
fun ListCard() {
    val scrollState1 = rememberScrollState()
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.horizontalScroll(scrollState1)) {
        for (i in 0..2) {
            CardCloth()
        }
    }
}