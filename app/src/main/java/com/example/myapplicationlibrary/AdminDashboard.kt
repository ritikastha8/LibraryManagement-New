package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationlibrary.databinding.ActivityAdminDashboardBinding


class AdminDashboard : AppCompatActivity() {

    private lateinit var binding: ActivityAdminDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityAdminDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listeners for buttons
        binding.btnaddd.setOnClickListener {
            // Navigate to AddBookActivity
            startActivity(Intent(this, BookadminActivity::class.java))
        }

        binding.btnupdatebookdetails.setOnClickListener {
            // Navigate to UpdateBookActivity
            startActivity(Intent(this, UpdatebookadminActivity::class.java))
        }

        binding.Addcategoryid.setOnClickListener {
            // Navigate to AddCategoryActivity
            startActivity(Intent(this, AddCategoryActivity::class.java))
        }

        binding.viewrequestbttn.setOnClickListener {
            // Navigate to ViewRequestActivity
            startActivity(Intent(this, ViewRequestAdmin::class.java))
        }
    }
}