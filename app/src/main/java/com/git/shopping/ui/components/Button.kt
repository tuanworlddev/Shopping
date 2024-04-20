package com.git.shopping.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.git.shopping.R
import com.git.shopping.ui.theme.MainGray
import com.git.shopping.ui.theme.MainPurple
import com.git.shopping.ui.theme.circularFont

@Composable
fun ButtonInterface(title: String) {
    Row() {
        SpacerWidth(int = 20)
        Box(modifier = Modifier
            .weight(1f)
            .height(49.dp), contentAlignment = Alignment.Center){
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxSize(), colors = ButtonDefaults.buttonColors(containerColor = MainPurple
            )
            ) {
                Text(text = title, fontFamily = circularFont, style = TextStyle(fontSize = 16.sp))
            }
        }
        SpacerWidth(int = 20)
    }
}

@Composable
fun ButtonContinueWith(image: Int, title: String) {
    Row {
        SpacerWidth(int = 20)
        Box(modifier = Modifier
            .weight(1f)
            .height(49.dp)){
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxSize(),
                colors = ButtonDefaults.buttonColors(containerColor = MainGray
            )) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .width(30.dp) // Canh giữa theo trục dọc
                    )
                    SpacerWidth(int = 50)
                    Text(
                        text = title,
                        fontFamily = circularFont,
                        fontSize = 16.sp,
                        style = TextStyle(color = Color.Black),
                        modifier = Modifier.weight(1f) // Sử dụng weight để căn giữa văn bản
                    )
                }
            }
        }
        SpacerWidth(int = 20)
    }
}

@Composable
fun ButtonBack() {
    Row {
        SpacerWidth(int = 20)
        androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.iconback),
            contentDescription = null, modifier = Modifier.size(40.dp))
        SpacerWidth(int = 20)
    }
}

@Composable
fun ButtonBackAndAdd() {
    Row {
        SpacerWidth(int = 20)
        androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.iconback),
            contentDescription = null, modifier = Modifier.size(40.dp))
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(color = MainGray), contentAlignment = Alignment.Center){
            androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.add),
                contentDescription = null, modifier = Modifier.size(16.dp))
        }
        SpacerWidth(int = 20)
    }
}

@Composable
fun ButtonBackAndTitle(text: String) {
    Row {
        SpacerWidth(int = 20)
        Row(modifier = Modifier.weight(1f)) {
            androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.iconback),
                contentDescription = null, modifier = Modifier.size(40.dp))
            Spacer(modifier = Modifier.weight(1f))
            Text(text = text, fontFamily = circularFont, fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterVertically))
            Spacer(modifier = Modifier.weight(1f))
        }
        SpacerWidth(int = 60)
    }
}

@Composable
fun ButtonResize(text: String, height: Int, width: Int) {
    Row() {
        SpacerWidth(int = 20)
        Box(modifier = Modifier
            .weight(1f)
            .height(49.dp), contentAlignment = Alignment.Center){
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .height(height.dp)
                .width(width.dp), colors = ButtonDefaults.buttonColors(containerColor = MainPurple)
            ) {
                Text(text = text, fontFamily = circularFont, style = TextStyle(fontSize = 15.sp))
            }
        }
        SpacerWidth(int = 20)
    }
}