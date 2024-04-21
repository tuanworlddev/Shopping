package com.git.shopping.ui.screens.product.edit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.git.shopping.ui.components.AreaFillWithDefaultValue
import com.git.shopping.ui.components.ButtonBackAndTitle
import com.git.shopping.ui.components.ButtonInterface
import com.git.shopping.ui.components.ButtonResize
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.components.SpacerWidth
import com.git.shopping.ui.components.ThemeProduct
import com.git.shopping.ui.components.TitleClothEdit
import com.git.shopping.ui.theme.circularFont

@Composable
fun EditProductScreen() {
    Column {
        SpacerHeight(int = 60)
        ButtonBackAndTitle(text = "Edit Product")
        SpacerHeight(int = 20)
        ThemeProduct()
        SpacerHeight(int = 20)
        TitleClothEdit(title = "Name")
        AreaFillWithDefaultValue(title = "Name", defaultValue = "Hoodie E T K")
        Row {
            Row(modifier = Modifier
                .weight(1f)
                .height(100.dp)) {
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()){
                    Column {
                        TitleClothEdit(title = "Price")
                        Row {
                            Box(modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()) {
                                AreaFillWithDefaultValue(title = "Price", defaultValue = "100")
                            }
                            Text(text = "$", fontFamily = circularFont, fontSize = 22.sp,
                                modifier = Modifier.align(Alignment.CenterVertically))
                            SpacerWidth(int = 20)
                        }
                    }
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()){
                    Column {
                        TitleClothEdit(title = "Quantity")
                        Row {
                            Box(modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()) {
                                AreaFillWithDefaultValue(title = "Quantity", defaultValue = "100")
                            }
                        }
                    }
                }
            }

        }
        SpacerHeight(int = 20)
        Row {
            Row(modifier = Modifier
                .weight(1f)
                .height(100.dp)) {
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()){
                    Column {
                        TitleClothEdit(title = "ReUpImage")
                        ButtonInterface(title = "Upload")
                    }
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()){
                    Column {
                        TitleClothEdit(title = "Sale")
                        Row {
                            Box(modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()) {
                                AreaFillWithDefaultValue(title = "Sale", defaultValue = "100")
                            }
                            Text(text = "%", fontFamily = circularFont, fontSize = 22.sp,
                                modifier = Modifier.align(Alignment.CenterVertically))
                            SpacerWidth(int = 20)
                        }
                    }
                }
            }
        }
        SpacerHeight(int = 80)
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Row {
                ButtonResize(text = "Save", height = 80, width = 100)
            }
            Spacer(modifier = Modifier.weight(1f))
        }

    }
}