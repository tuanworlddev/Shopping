package com.git.shopping.ui.screens.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.git.shopping.models.Category
import com.google.firebase.Firebase
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import kotlinx.coroutines.tasks.await
import okhttp3.internal.wait

class CategoryViewModel : ViewModel() {
    private val categoryCollection = Firebase.firestore.collection("categories")

    fun getAllCategories(): LiveData<List<Category>> {
        val categoriesLiveData = MutableLiveData<List<Category>>()
        categoryCollection.addSnapshotListener { snapshot, _ ->
            val categories = snapshot?.documents?.mapNotNull { doc ->
                doc.toObject(Category::class.java)?.apply {
                    id = doc.id
                }
            }
            categoriesLiveData.value = categories!!
        }
        return categoriesLiveData
    }
    suspend fun getCategory(categoryId: String): Category? {
        val document = categoryCollection.document(categoryId).get().await()
        return document.toObject(Category::class.java)?.apply {
            id = document.id
        }
    }
    fun addCategory(category: Category) {
        categoryCollection.add(category)
    }

    fun updateCategory(category: Category) {
        category.id?.let {
            categoryCollection.document(it).set(category, SetOptions.merge())
        }
    }

    fun deleteCategory(categoryId: String) {
        categoryCollection.document(categoryId).delete()
    }
}

