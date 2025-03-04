package com.example.myapplicationlibrary

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationlibrary.Model.AddCategoryModel
import com.example.myapplicationlibrary.ViewModel.AddCategoryViewModel
import com.example.myapplicationlibrary.adapter.BookAdapter
import com.example.myapplicationlibrary.adapter.BookAdapterr
import com.example.myapplicationlibrary.databinding.ActivityAddCategoryBinding

class AddCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddCategoryBinding
    private val viewModel: AddCategoryViewModel by viewModels()
    private lateinit var bookAdapter: BookAdapterr // RecyclerView adapter for books
    private val bookList = mutableListOf<String>() // List to hold book titles

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityAddCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        bookAdapter = BookAdapterr(bookList)
        binding.recyclerViewBooks.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewBooks.adapter = bookAdapter

        // Add button click listener
        binding.btnAddBook.setOnClickListener {
            Toast.makeText(this, "Book added succesfully!", Toast.LENGTH_SHORT).show()
            val bookTitle = binding.etBookTitle.text.toString().trim()
//            if (bookTitle.isNotEmpty()) {
//                bookList.add(bookTitle)
//                bookAdapter.notifyDataSetChanged()
//                binding.etBookTitle.text.clear() // Clear input field
//            } else {
//                Toast.makeText(this, "Please enter a book title", Toast.LENGTH_SHORT).show()
//            }
        }

        // Add category button click listener
        binding.btnAddCategory.setOnClickListener {
            Toast.makeText(this, "Category added succesfully!", Toast.LENGTH_SHORT).show()
//            val categoryTitle = binding.etCategoryTitle.text.toString().trim()
//            if (categoryTitle.isNotEmpty() && bookList.isNotEmpty()) {
//                val category = AddCategoryModel(categoryTitle, bookList)
//                viewModel.addCategory(category)
//            } else {
//                Toast.makeText(this, "Please enter a category title and add at least one book", Toast.LENGTH_SHORT).show()
//            }
        }

        // Observe add category status
//        viewModel.addCategoryStatus.observe(this) { resource ->
//            when (resource) {
//                is AddCategoryViewModel.Resource.Loading -> {
//                    // Show loading indicator if needed
//                }
//                is AddCategoryViewModel.Resource.Success -> {
//                    Toast.makeText(this, resource.data, Toast.LENGTH_SHORT).show()
//                    finish() // Close the activity
//                }
//                is AddCategoryViewModel.Resource.Error -> {
//                    Toast.makeText(this, resource.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }
}