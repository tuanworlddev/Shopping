package com.git.shopping.models

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(
    val title: String,
    val icon: ImageVector? = null,
    val route: String
)
