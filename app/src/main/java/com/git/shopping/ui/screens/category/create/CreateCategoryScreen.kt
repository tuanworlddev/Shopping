package com.git.shopping.ui.screens.category.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.git.shopping.R
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.components.SpacerWidth
import com.git.shopping.ui.theme.Black50
import com.git.shopping.ui.theme.Light2
import com.git.shopping.ui.theme.circularFont

@Composable
fun CreateCategoryScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var name by remember {
                mutableStateOf("")
            }
            var messageState by remember {
                mutableStateOf("Added category successfully!")
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondaryContainer)
            ) {
                Text(
                    text = stringResource(id = R.string.create_category),
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    color = Color.Black,
                    modifier = Modifier.padding(10.dp)
                )
            }
            SpacerHeight(int = 20)
            if (messageState.isNotEmpty()) {
                Row(

                ) {

                }
            }
            SpacerHeight(int = 15)
            val placeholderStyle = TextStyle.Default.copy(fontWeight = FontWeight.Light, fontFamily = circularFont, color = Black50)
            Row {
                Surface(
                    color = Light2,
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    OutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .weight(1f)
                            .background(
                                color = Light2
                            ),
                        placeholder =  { Text(text = "Enter product category", style = placeholderStyle) },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Black50
                        )

                    )
                }
            }
            SpacerHeight(int = 20)
            Surface(
                modifier = Modifier.padding(10.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.add))
                }
            }
        }
    }
}