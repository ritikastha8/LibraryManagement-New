package com.example.myapplicationlibrary

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationlibrary.databinding.ActivityBorrowBookBinding


class BorrowBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBorrowBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityBorrowBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listener for the borrow button
        binding.buttonborrow.setOnClickListener {
            // Get the input values
            val username = binding.username.text.toString().trim()
            val bookId = binding.bookid.text.toString().trim()
            val bookName = binding.bookname.text.toString().trim()
            val issueDate = binding.datei.text.toString().trim()
            val dueDate = binding.dated.text.toString().trim()

            // Validate input fields
            if (username.isEmpty() || bookId.isEmpty() || bookName.isEmpty() || issueDate.isEmpty() || dueDate.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Show a Toast message indicating the book has been borrowed
                Toast.makeText(this, "Book borrowed successfully!", Toast.LENGTH_SHORT).show()


            }
        }
    }
}