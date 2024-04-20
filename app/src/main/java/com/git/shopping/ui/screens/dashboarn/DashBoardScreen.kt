package com.git.shopping.ui.screens.dashboarn

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.git.shopping.ui.components.ButtonInterface
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.components.TitleLogin

@Composable
fun DashBoard() {
    Column {
        SpacerHeight(int = 123)
        TitleLogin(text = "Hello Admin")
        SpacerHeight(int = 40)
        ButtonInterface(title = "List Product")
        SpacerHeight(int = 40)
        ButtonInterface(title = "List Order")
        SpacerHeight(int = 40)
        ButtonInterface(title = "statistical")
    }
}