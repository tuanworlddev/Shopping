package com.git.shopping.ui.screens.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthViewModel() : ViewModel() {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    var userCurrent = firebaseAuth.currentUser

    fun onLogin(email: String, password: String, loginListener: AuthListener) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    loginListener.onSuccess()
                    userCurrent = firebaseAuth.currentUser
                } else {
                    loginListener.onFailure("Login error: ${task.exception}")
                }
            }
    }
    fun onRegister(email: String, password: String, registerListener: AuthListener) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    registerListener.onSuccess()
                } else {
                    registerListener.onFailure("Register error: ${task.exception}")
                }
            }
    }

    fun logout() {
        firebaseAuth.signOut()
        userCurrent = firebaseAuth.currentUser
    }

}