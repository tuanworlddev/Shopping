package com.git.shopping.ui.screens.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.git.shopping.models.Category
import com.git.shopping.models.Product
import com.google.firebase.Firebase
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class ProductViewModel : ViewModel() {
    private val productsCollection = Firebase.firestore.collection("products")

    fun getAllProducts(): LiveData<List<Product>> {
        val productsLiveData = MutableLiveData<List<Product>>()
        productsCollection.addSnapshotListener { snapshot, _ ->
            val products = snapshot?.documents?.mapNotNull { doc ->
                doc.toObject(Product::class.java)?.apply {
                    id = doc.id
                }
            }
            productsLiveData.value = products!!
        }
        return productsLiveData
    }
    fun getProduct(productId: String, callback: (Product?) -> Unit) {
        productsCollection.document(productId).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                val product = document.toObject(Product::class.java)?.apply {
                    id = document.id
                }
                callback(product)
            } else {
                callback(null)
            }
        }
    }
    fun addProduct(product: Product) {
        productsCollection.add(product)
    }

    fun updateProduct(product: Product) {
        product.id?.let {
            productsCollection.document(it).set(product, SetOptions.merge())
        }
    }

    fun deleteProduct(productId: String) {
        productsCollection.document(productId).delete()
    }
}