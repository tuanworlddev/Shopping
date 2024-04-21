package com.git.shopping.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cards")
class Cart {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var productId: String = ""
    var productName: String = ""
    var productPrice: Double = 0.0
    var productImage: String = ""
    var quantity: Int = 0
    var priceTotal: Double = 0.0
}