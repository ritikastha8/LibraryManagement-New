package com.example.myapplicationlibrary

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c35c.repository.RequestRepositoryImpl
import com.example.myapplicationlibrary.databinding.ActivityUpdateRequestBinding
import com.example.myapplicationlibrary.viewmodel.RequestViewModel
import com.google.firebase.database.FirebaseDatabase

class UpdateRequestActivity : AppCompatActivity() {
    lateinit var binding:ActivityUpdateRequestBinding
    lateinit var requestViewModel: RequestViewModel
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityUpdateRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repo = RequestRepositoryImpl(FirebaseDatabase.getInstance())
        requestViewModel=RequestViewModel(repo)

        var id : String= intent.getStringExtra("requestidd").toString()
        //get garne code
        requestViewModel.getRequestById(id)
        requestViewModel.requests.observe(this){
            binding.editupdaterequest.setText(it?.requestdescription.toString())

        }
        //update garna lai code
        binding.buttonupdaterequest.setOnClickListener {
            val newRequestDescription = binding.editupdaterequest.text.toString()


            var updateMap= mutableMapOf<String,Any>()
            updateMap["requestdescription"]=newRequestDescription


            requestViewModel.updateRequest(id,updateMap){
                    success,message->
                if(success){
                    Toast.makeText(this@UpdateRequestActivity,
                        message, Toast.LENGTH_LONG).show()
                    finish()
                }else{
                    Toast.makeText(this@UpdateRequestActivity,
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

