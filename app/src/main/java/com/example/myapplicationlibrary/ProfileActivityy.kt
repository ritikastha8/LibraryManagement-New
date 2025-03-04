package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationlibrary.databinding.ActivityChangepasswordBinding
import com.example.myapplicationlibrary.databinding.ActivityProfileActivityyBinding

class ProfileActivityy : AppCompatActivity() {

    lateinit var binding: ActivityProfileActivityyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize View Binding
        binding = ActivityProfileActivityyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnabout.setOnClickListener {
            // Navigate to AddBookActivity
            startActivity(Intent(this, AboutActivity::class.java))
        }

        binding.btnset.setOnClickListener {
            // Navigate to AddBookActivity
            startActivity(Intent(this, ChangepasswordActivity::class.java))
        }


        binding.btnmainpage.setOnClickListener {
            // Navigate to AddBookActivity
            startActivity(Intent(this, HomeActivity::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}