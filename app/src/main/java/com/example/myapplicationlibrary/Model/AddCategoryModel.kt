package com.example.myapplicationlibrary.Model



data class AddCategoryModel(
    val categoryTitle: String,
    val books: List<String> // List of book titles
)