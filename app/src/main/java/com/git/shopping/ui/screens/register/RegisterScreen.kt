package com.git.shopping.ui.screens.register

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.git.shopping.ui.components.AreaFill
import com.git.shopping.ui.components.ButtonBack
import com.git.shopping.ui.components.ButtonInterface
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.components.TitleLogin
import com.git.shopping.ui.components.TitleWhenLogin

@Composable
fun CreateAccount() {
    Column {
        SpacerHeight(int = 60)
        ButtonBack()
        SpacerHeight(int = 20)
        TitleLogin(text = "Create Account")
        SpacerHeight(int = 32)
        AreaFill(text1 = "FirstName")
        SpacerHeight(int = 20)
        AreaFill(text1 = "LastName")
        SpacerHeight(int = 20)
        AreaFill(text1 = "Email Address")
        SpacerHeight(int = 20)
        AreaFill(text1 = "Password")
        SpacerHeight(int = 40)
        ButtonInterface(title = "Continue")
        SpacerHeight(int = 40)
        TitleWhenLogin(question = "Forgot Password ? ", solution = "Reset")
    }
}