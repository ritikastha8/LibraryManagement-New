package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationlibrary.databinding.ActivityAdminDashboardBinding
import com.example.myapplicationlibrary.databinding.ActivityChangepasswordBinding

class ChangepasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChangepasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize View Binding
        binding = ActivityChangepasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        binding.btn.setOnClickListener {
            // Navigate to AddBookActivity
            Toast.makeText(this, "Password Updated successfully!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, ProfileActivityy::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}



