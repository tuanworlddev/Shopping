package com.git.shopping.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.git.shopping.R
import com.git.shopping.ui.theme.MainGray
import com.git.shopping.ui.theme.circularFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarTop() {
    var query by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    Spacer(modifier = Modifier.height(22.dp))
    Row {
        SearchBar(query = query, onQueryChange = {query = it}, onSearch = { newQuery ->
            print("ABC: $newQuery")
        }, active = active, onActiveChange = {}, placeholder = { Text(text = "Search",
            fontFamily = circularFont)
        },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(),
            colors = SearchBarDefaults.colors(MainGray),
            leadingIcon = {
                Image(painter = painterResource(id = R.drawable.searchnormal1),
                    contentDescription = null, modifier = Modifier.size(18.dp))
            }
        ) {

        }
    }
}