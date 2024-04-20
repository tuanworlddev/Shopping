package com.git.shopping.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.git.shopping.R

@Composable
fun ContinueWith(){
    Column {
        ButtonContinueWith(image = R.drawable.apple, title = "Continue With Apple")
        SpacerHeight(int = 10)
        ButtonContinueWith(image = R.drawable.google, title = "Continue With Google")
        SpacerHeight(int = 10)
        ButtonContinueWith(image = R.drawable.facebook, title = "Continue With Facebook")
    }
}