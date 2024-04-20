package com.git.shopping.models

import java.math.BigDecimal

data class Product(
    val id: String? = null,
    val name: String,
    val price: BigDecimal,
    val quantity: Int,
    val description: String,
    val category: String,
    val image: String,
    val sale: Float
)