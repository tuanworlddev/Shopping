package com.git.shopping.constants

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import com.git.shopping.models.NavItem

object NavItems {
    val navItems = listOf(
        NavItem(
            title = "Create Product",
            icon = Icons.Outlined.Add,
            route = "create_product"
        )
    )

    val bottomNavItems = listOf(
        NavItem(
            title = "Home",
            icon = Icons.Outlined.Home,
            route = "home"
        ),
        NavItem(
            title = "Notification",
            icon = Icons.Outlined.Notifications,
            route = "notification"
        ),
        NavItem(
            title = "Order",
            icon = Icons.Outlined.CheckCircle,
            route = "order"
        ),
        NavItem(
            title = "Profile",
            icon = Icons.Outlined.Person,
            route = "profile"
        )
    )

    val topNavItems = listOf(
        NavItem(
            title = "Search",
            icon = Icons.Outlined.Search,
            route = "search"
        )
    )
}