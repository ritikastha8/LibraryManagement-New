package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationlibrary.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity() {

    // Initialize ViewBinding
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object
        binding = ActivityHomeBinding.inflate(layoutInflater)

        // Set the root view to the one bound by ViewBinding
        setContentView(binding.root)

        // Set up listeners for buttons

        binding.borrowBook.setOnClickListener {
            // Navigate to BorrowBookActivity
            val intent = Intent(this, BorrowBookActivity::class.java)
            startActivity(intent)
        }

        binding.request.setOnClickListener {
            // Navigate to RequestBookActivity
            val intent = Intent(this, RequestBookActivity::class.java)
            startActivity(intent)
        }

        binding.returnBook.setOnClickListener {
            // Navigate to ReturnBookActivity
            val intent = Intent(this, ReturnBookActivity::class.java)
            startActivity(intent)
        }

        binding.buttonProfile.setOnClickListener {
            // Navigate to ProfileActivity
            val intent = Intent(this, ProfileActivityy::class.java)
            startActivity(intent)
        }

        binding.Category.setOnClickListener {
            // Navigate to CategoryActivity
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }
    }
}