package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c35c.model.RequestModel
import com.example.c35c.repository.RequestRepositoryImpl
import com.example.myapplicationlibrary.databinding.ActivityRequestBinding
import com.example.myapplicationlibrary.viewmodel.RequestViewModel
import com.google.firebase.database.FirebaseDatabase

class RequestActivity : AppCompatActivity() {
    lateinit var binding: ActivityRequestBinding
    lateinit var requestViewModel: RequestViewModel
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var repo = RequestRepositoryImpl(FirebaseDatabase.getInstance())
        requestViewModel = RequestViewModel(repo)

        binding.buttonrequest.setOnClickListener {
            var requestdescription = binding.editrequest.text.toString()
            var model = RequestModel("",requestdescription)
            requestViewModel.addRequest(model){
                    success,message->
                if(success){
                    Toast.makeText(this@RequestActivity,
                        message, Toast.LENGTH_LONG).show()
                    val intent= Intent(
                        this@RequestActivity,
                        UpdateRequestActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@RequestActivity,
                        message, Toast.LENGTH_LONG).show()
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


}

