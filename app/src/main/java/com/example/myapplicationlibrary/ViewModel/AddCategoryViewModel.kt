package com.example.myapplicationlibrary.ViewModel

import com.example.myapplicationlibrary.Model.AddCategoryModel
import com.example.myapplicationlibrary.Repository.AddCategoryRepository
import com.example.myapplicationlibrary.Repository.AddCategoryRepositoryImpl



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class AddCategoryViewModel : ViewModel() {
    private val repository: AddCategoryRepository = AddCategoryRepositoryImpl()

    val addCategoryStatus = MutableLiveData<Resource<String>>()

    fun addCategory(category: AddCategoryModel) {
        addCategoryStatus.value = Resource.Loading()
        repository.addCategory(category) { success, message ->
            if (success) {
                addCategoryStatus.value = Resource.Success(message)
            } else {
                addCategoryStatus.value = Resource.Error(message)
            }
        }
    }

    sealed class Resource<T> {
        class Success<T>(val data: T) : Resource<T>()
        class Error<T>(val message: String) : Resource<T>()
        class Loading<T> : Resource<T>()
    }
}