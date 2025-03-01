package com.example.myapplicationlibrary.Model


data class AddCategoryModel(
    val categoryTitle: String = "",
    val books: List<String> = listOf() // List of book titles
)