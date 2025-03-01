package com.example.myapplicationlibrary.Repository

import com.example.myapplicationlibrary.Model.UserModel


interface UserRepository {
    fun signup(user: UserModel, callback: (Boolean, String) -> Unit)
    fun login(email: String, password: String, callback: (Boolean, String) -> Unit)
}