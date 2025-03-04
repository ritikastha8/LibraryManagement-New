package com.example.myapplicationlibrary.Repository

import com.example.myapplicationlibrary.Model.AddCategoryModel

import com.google.firebase.firestore.FirebaseFirestore

class AddCategoryRepositoryImpl : AddCategoryRepository {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun addCategory(category: AddCategoryModel, callback: (Boolean, String) -> Unit) {
        db.collection("categories").add(category)
            .addOnSuccessListener {
                callback(true, "Category added successfully")
            }
            .addOnFailureListener { e ->
                callback(false, e.message ?: "Failed to add category")
            }
    }
}