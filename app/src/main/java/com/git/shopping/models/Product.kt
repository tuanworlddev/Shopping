package com.git.shopping.models

import java.math.BigDecimal

data class Product(
    var id: String? = null,
    val name: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0,
    val description: String = "",
    val category: String = "",
    val image: String = "",
    val sale: Double = 0.0
)