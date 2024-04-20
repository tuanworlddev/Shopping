package com.git.shopping.models

data class User(
    val uid: String,
    val name: String,
    val email: String,
    val photoUrl: String,
    val emailVerified: Boolean,
)
