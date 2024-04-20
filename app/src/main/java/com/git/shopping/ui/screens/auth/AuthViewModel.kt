package com.git.shopping.ui.screens.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.git.shopping.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class AuthViewModel() : ViewModel() {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val userCurrent = FirebaseAuth.getInstance().currentUser


    fun onLogin(email: String, password: String): Boolean {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("login", "Đăng nhập thành công!")
                    return@addOnCompleteListener
                } else {
                    Log.w("login", "Đăng nhập thất bại!", task.exception)
                }
            }
        return false
    }
    fun onRegister(email: String, password: String): Boolean {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("register", "Đăng ký thành công!")
                    return@addOnCompleteListener
                } else {
                    Log.w("register", "Đăng ký thất bại!", task.exception)
                }
            }
        return false
    }

    fun logout() {
        firebaseAuth.signOut()
    }
}