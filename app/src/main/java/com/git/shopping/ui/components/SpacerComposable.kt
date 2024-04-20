package com.git.shopping.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerWidth(int: Int) {
    Spacer(modifier = Modifier.width(int.dp))
}

@Composable
fun SpacerHeight(int: Int) {
    Spacer(modifier = Modifier.height(int.dp))
}