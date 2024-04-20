package com.git.shopping.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.git.shopping.ui.components.Categories
import com.git.shopping.ui.components.Header
import com.git.shopping.ui.components.ListCard
import com.git.shopping.ui.components.SearchBarTop
import com.git.shopping.ui.components.TitleCloth

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.verticalScroll(scrollState)) {
        Header()

        SearchBarTop()

        TitleCloth(title = "Categories")

        Categories()

        TitleCloth(title = "Top Selling")

        ListCard()

        TitleCloth(title = "New In")

        ListCard()
    }
}



