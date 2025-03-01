package com.example.myapplicationlibrary.Repository

import com.example.myapplicationlibrary.Model.UserModel

import com.google.firebase.auth.FirebaseAuth

abstract class UserRepositoryImpl : UserRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun signup(user: UserModel, callback: (Boolean, String) -> Unit) {
        auth.createUserWithEmailAndPassword(user.email, user.password) // Corrected method name
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                callback(true, "Signup successful")
            } else {
                callback(false, task.exception?.message ?: "Signup failed")
            }
        }
    }

    override fun login(email: String, password: String, callback: (Boolean, String) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    callback(true, "Login successful")
                } else {
                    callback(false, task.exception?.message ?: "Login failed")
                }
            }
    }
}
