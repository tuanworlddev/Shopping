package com.git.shopping.ui.screens.forgotpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.git.shopping.ui.components.AreaFill
import com.git.shopping.ui.components.ButtonBack
import com.git.shopping.ui.components.ButtonInterface
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.components.TitleLogin

@Composable
fun ForgotPassword() {
    Column {
        SpacerHeight(int = 60)
        ButtonBack()
        SpacerHeight(int = 20)
        TitleLogin(text = "Forgot Password")
        SpacerHeight(int = 32)
        AreaFill(text1 = "Enter Email Address")
        SpacerHeight(int = 24)
        ButtonInterface(title = "Continue")
    }
}