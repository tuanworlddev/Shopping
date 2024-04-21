package com.git.shopping.ui.screens.firebase

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import java.util.UUID

class UploadViewModel : ViewModel() {
    private val storage = Firebase.storage.reference

    fun uploadImage(imageUri: Uri, onSuccess: (String) -> Unit, onFailure: (String) -> Unit) {
        val imageRef = storage.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putFile(imageUri)
        uploadTask.addOnCompleteListener { task ->
            imageRef.downloadUrl.addOnSuccessListener {
                onSuccess(it.toString())
            }.addOnFailureListener {
                onFailure(it.message.toString() ?: "Download URL failed.")
            }
        }.addOnFailureListener { exception ->
            onFailure(exception.message ?: "Upload failed.")
        }
    }

    fun deleteImage(imageUrl: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        val storageReference = Firebase.storage.getReferenceFromUrl(imageUrl)

        storageReference.delete()
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener { exception ->
                onFailure(exception.message ?: "Delete failed.")
            }
    }
}