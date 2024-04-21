package com.git.shopping.ui.screens.category.create

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.git.shopping.R
import com.git.shopping.models.Category
import com.git.shopping.ui.components.SpacerHeight
import com.git.shopping.ui.screens.category.CategoryViewModel
import com.git.shopping.ui.screens.firebase.UploadViewModel
import com.git.shopping.ui.theme.BgSuccess
import com.git.shopping.ui.theme.Black50
import com.git.shopping.ui.theme.BorderSuccess
import com.git.shopping.ui.theme.Light2
import com.git.shopping.ui.theme.TextSuccess
import com.git.shopping.ui.theme.circularFont
import kotlin.contracts.contract

@Composable
fun CreateCategoryScreen(
    context: Context,
    categoryViewModel: CategoryViewModel,
    uploadViewModel: UploadViewModel
) {
    var name by remember {
        mutableStateOf("")
    }
    var selectedImageUri by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {

            var messageState by remember {
                mutableStateOf("")
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
                Surface(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(BgSuccess, shape = MaterialTheme.shapes.small)
                            .border(1.dp, BorderSuccess, MaterialTheme.shapes.small)
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = messageState,
                            color = TextSuccess
                        )
                    }
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
            ImagePicker(context = context, uploadViewModel = uploadViewModel) { imageUrl ->
                selectedImageUri = imageUrl
            }
            SpacerHeight(int = 20)
            Surface(
                modifier = Modifier.padding(10.dp)
            ) {
                Button(
                    onClick = {
                        messageState = ""
                        if (name.isBlank()) {
                            Toast.makeText(context, "Name is required", Toast.LENGTH_SHORT).show()
                        } else if (selectedImageUri.isBlank()) {
                            Toast.makeText(context, "Image is required", Toast.LENGTH_SHORT).show()
                        } else {
                            categoryViewModel.addCategory(Category(name = name, image = selectedImageUri))
                            name = ""
                            selectedImageUri = ""
                            messageState = "Added category successfully!"
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(id = R.string.add))
                }
            }
        }
    }

}

@Composable
fun ImagePicker(
    context: Context,
    uploadViewModel: UploadViewModel,
    onImageSelected: (String) -> Unit
) {
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                selectedImageUri = uri
                uploadViewModel.uploadImage(
                    it,
                    onSuccess = { imageUrl ->
                        onImageSelected(imageUrl)
                    },
                    onFailure = { error ->
                        Toast.makeText(context, "Upload failed: $error", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    )

    Image(
        painter = if (selectedImageUri != null) rememberAsyncImagePainter(model = selectedImageUri) else painterResource(id = R.drawable.resource_default),
        contentDescription = null,
        modifier = Modifier.clickable {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.type = "image/*"
            launcher.launch(intent.type)
        }
    )

}



