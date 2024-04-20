package com.git.shopping.ui.screens.waiting

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.git.shopping.R
import com.git.shopping.ui.components.ButtonResize
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.theme.circularFont

@Composable
fun WaitingSendEmail() {
    Column {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.email),
                contentDescription = null, modifier = Modifier.size(100.dp))
            SpacerHeight(int = 24)
            Text(text = "We Send you an Email to reset your Passwords", fontFamily = circularFont,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight(500)), modifier = Modifier.align(
                    Alignment.CenterHorizontally
                ), textAlign = TextAlign.Center
            )
            SpacerHeight(int = 24)
            ButtonResize(text = "Return to Login", height = 52, width = 159)
        }
    }
}