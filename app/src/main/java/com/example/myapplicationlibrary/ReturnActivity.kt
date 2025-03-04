package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplicationlibrary.databinding.ActivityBookadminBinding
import com.example.myapplicationlibrary.databinding.ActivityRequestBinding
import com.example.myapplicationlibrary.databinding.ActivityReturnBinding

class ReturnActivity : AppCompatActivity() {
    lateinit var binding : ActivityReturnBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityReturnBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        binding.btnreturn.setOnClickListener {
            Toast.makeText(this, "Returned successfully!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeActivity::class.java))
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}