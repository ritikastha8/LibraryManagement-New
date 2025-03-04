package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationlibrary.AdminDashboard
import com.example.myapplicationlibrary.HomeActivity
import com.example.myapplicationlibrary.SignupActivity
import com.example.myapplicationlibrary.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle login button click
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Proceed to HomeActivity for any user
            var intent = Intent(this, HomeActivity::class.java)

            // Check if the user is admin and send them to AdminDashboardActivity
            if (username == "admin" && password == "1234") {
                intent = Intent(this, AdminDashboard::class.java)
            }

            // Start the appropriate activity (Home or Admin Dashboard)
            startActivity(intent)
            finish()
        }

        // Handle sign-up click
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
