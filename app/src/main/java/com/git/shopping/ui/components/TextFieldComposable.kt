package com.git.shopping.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.git.shopping.ui.theme.Black50
import com.git.shopping.ui.theme.Light2
import com.git.shopping.ui.theme.MainGray
import com.git.shopping.ui.theme.MainPurple
import com.git.shopping.ui.theme.PlaceHolderColor
import com.git.shopping.ui.theme.circularFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AreaFill(text1: String) {
    var text by remember {
        mutableStateOf("")
    }

    val placeholderStyle = TextStyle.Default.copy(fontWeight = FontWeight.Light,
        fontFamily = circularFont, color = MainPurple
    )
    Row {
        SpacerWidth(int = 20)
        Surface(
            color = MainGray, // Màu nền của Surface
            shape = RoundedCornerShape(8.dp), // Bo tròn góc
            modifier = Modifier.weight(1f)
        ) {
            OutlinedTextField(value = text, onValueChange = {text = it},shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = MainGray
                    ),
                placeholder =  { Text(text = text1, style = placeholderStyle)},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MainGray,
                    unfocusedBorderColor = MainGray
                )

            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AreaFillWithDefaultValue(title: String, defaultValue: String) {
    var text by remember {
        mutableStateOf("")
    }

    text = defaultValue

    val placeholderStyle = TextStyle.Default.copy(fontWeight = FontWeight.Light, fontFamily = circularFont, color = PlaceHolderColor)
    Row {
        SpacerWidth(int = 20)
        Surface(
            color = MainGray, // Màu nền của Surface
            shape = RoundedCornerShape(8.dp), // Bo tròn góc
            modifier = Modifier.weight(1f)
        ) {
            OutlinedTextField(value = text,
                onValueChange = {
                    text = it
                },shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = MainGray
                    ),
                placeholder =  { Text(text = title, style = placeholderStyle)},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MainGray,
                    unfocusedBorderColor = MainGray
                )

            )
        }
        SpacerWidth(int = 20)

    }
}