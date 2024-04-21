package com.git.shopping.ui.screens.waiting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.git.shopping.R
import com.git.shopping.ui.theme.MainPurple

@Composable
fun WaitingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = MainPurple),
            contentAlignment = Alignment.Center)
        {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = null,
                modifier = Modifier.width(175.dp))
        }
    }
}