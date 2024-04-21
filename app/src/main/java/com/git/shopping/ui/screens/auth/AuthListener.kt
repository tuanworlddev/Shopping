package com.git.shopping.ui.screens.auth

interface AuthListener {
    fun onSuccess()
    fun onFailure(message: String)
}