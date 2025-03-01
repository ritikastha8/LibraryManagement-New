package com.example.myapplicationlibrary.ViewModel

import com.example.myapplicationlibrary.Model.UserModel
import com.example.myapplicationlibrary.Repository.UserRepository
import com.example.myapplicationlibrary.Repository.UserRepositoryImpl
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserViewModel : ViewModel() {
    private val userRepository: UserRepository = UserRepositoryImpl() // This should work now

    val signupStatus = MutableLiveData<Resource<String>>()
    val loginStatus = MutableLiveData<Resource<String>>()

    fun signup(user: UserModel) {
        signupStatus.value = Resource.Loading()
        userRepository.signup(user) { success, message ->
            if (success) {
                signupStatus.value = Resource.Success(message)
            } else {
                signupStatus.value = Resource.Error(message)
            }
        }
    }

    fun login(email: String, password: String) {
        loginStatus.value = Resource.Loading()
        userRepository.login(email, password) { success, message ->
            if (success) {
                loginStatus.value = Resource.Success(message)
            } else {
                loginStatus.value = Resource.Error(message)
            }
        }
    }

    sealed class Resource<T> {
        class Success<T>(val data: T) : Resource<T>()
        class Error<T>(val message: String) : Resource<T>()
        class Loading<T> : Resource<T>()
    }
}