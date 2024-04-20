package com.git.shopping.ui.screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.git.shopping.ui.components.AreaFill
import com.git.shopping.ui.components.ButtonInterface
import com.git.shopping.ui.components.ContinueWith
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.components.TitleLogin
import com.git.shopping.ui.components.TitleWhenLogin

@Composable
fun LoginScreen() {
    Column {
        SpacerHeight(int = 123)
        TitleLogin(text = "Sign in")
        SpacerHeight(int = 40)
        AreaFill(text1 = "Email Address")
        SpacerHeight(int = 20)
        ButtonInterface(title = "Continue")
        SpacerHeight(int = 20)
        TitleWhenLogin(question = "Don't have an Account ? ", solution = "Create One")
        SpacerHeight(int = 70)
        ContinueWith()
    }
}