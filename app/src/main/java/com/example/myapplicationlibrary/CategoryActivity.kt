package com.example.myapplicationlibrary

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationlibrary.Model.AddCategoryModel
import com.example.myapplicationlibrary.adapter.CategoryAdapter
import com.example.myapplicationlibrary.databinding.ActivityCategoryBinding
import com.google.firebase.firestore.FirebaseFirestore

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
//    private lateinit var categoryAdapter: CategoryAdapter
//    private val categoryList = mutableListOf<AddCategoryModel>() // List to hold categories

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Set up RecyclerView


        // Load categories from Firestore
//        loadCategories()
    }

//    private fun loadCategories() {
//        val db = FirebaseFirestore.getInstance()
//        db.collection("categories")
//            .get()
//            .addOnSuccessListener { documents ->
//                for (document in documents) {
//                    val category = document.toObject(AddCategoryModel::class.java)
//                    categoryList.add(category)
//                }
//                categoryAdapter.notifyDataSetChanged() // Notify adapter of data change
//            }
//            .addOnFailureListener { exception ->
//                // Handle the error
//            }
//    }
}