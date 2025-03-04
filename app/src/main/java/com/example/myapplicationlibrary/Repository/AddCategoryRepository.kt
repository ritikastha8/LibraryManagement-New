package com.example.myapplicationlibrary.Repository
import com.example.myapplicationlibrary.Model.AddCategoryModel

interface AddCategoryRepository {
    fun addCategory(category: AddCategoryModel, callback: (Boolean, String) -> Unit)
}