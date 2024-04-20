package com.git.shopping.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.git.shopping.ui.theme.circularFont

@Composable
fun TitleLogin(text: String) {
    Row {
        SpacerWidth(int = 20)
        Text(text = text, fontFamily = circularFont, style = TextStyle(fontSize = 35.sp,
            fontWeight = FontWeight(550))
        )
    }
}

@Composable
fun TitleWhenLogin(question: String, solution: String) {
    Row {
        SpacerWidth(int = 20)
        Row {
            Text(text = question, fontSize = 12.sp, fontFamily = circularFont)
            Text(text = solution, fontSize = 12.sp, fontFamily = circularFont, fontWeight = FontWeight(600))
        }
        SpacerWidth(int = 20)
    }
}

@Composable
fun TitleCloth(title:String) {
    Spacer(modifier = Modifier.height(22.dp))
    Row {
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title, fontFamily = circularFont, fontWeight = FontWeight(600))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "See All", fontFamily = circularFont)
        Spacer(modifier = Modifier.width(20.dp))
    }
}

@Composable
fun TitleClothEdit(title:String) {
    Spacer(modifier = Modifier.height(22.dp))
    Row {
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title, fontFamily = circularFont, fontWeight = FontWeight(600))
        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(20.dp))
    }
}