package com.git.shopping.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.git.shopping.ui.theme.Black50
import com.git.shopping.ui.theme.Light2
import com.git.shopping.ui.theme.circularFont

@Composable
fun BasicField(
    value: String,
    onNewValue: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier
) {

    val placeholderStyle = TextStyle.Default.copy(fontWeight = FontWeight.Light, fontFamily = circularFont, color = Black50)
    Row {
        SpacerWidth(20)
        Surface(
            color = Light2,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            OutlinedTextField(
                value = value,
                onValueChange = { onNewValue(it) },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = Light2
                    ),
                placeholder =  { Text(text = placeholder, style = placeholderStyle)},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Light2,
                    unfocusedTextColor = Light2
                )

            )
        }

    }
}