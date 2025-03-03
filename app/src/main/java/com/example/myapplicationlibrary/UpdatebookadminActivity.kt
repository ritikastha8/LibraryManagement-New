package com.example.myapplicationlibrary

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c35c.repository.BookRepositoryImpl
import com.example.myapplicationlibrary.databinding.ActivityUpdatebookadminBinding
import com.example.myapplicationlibrary.viewmodel.BookViewModel
import com.google.firebase.database.FirebaseDatabase

class UpdatebookadminActivity : AppCompatActivity() {
    lateinit var binding: ActivityUpdatebookadminBinding
    lateinit var bookViewModel: BookViewModel
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityUpdatebookadminBinding.inflate(layoutInflater)
        setContentView(binding.root)

//
        var repo = BookRepositoryImpl(FirebaseDatabase.getInstance())
        bookViewModel=BookViewModel(repo)
        var id : String= intent.getStringExtra("bookid").toString()

        //get code

        bookViewModel.getBookById(id)
        bookViewModel.books.observe(this){
            binding.updatebooktitleid.setText(it?.booktitleId.toString())
            binding.updatebookname.setText(it?.bookName.toString())
            binding.updatebookdescription.setText(it?.bookdescription.toString())
            binding.updateauthorname.setText(it?.bookauthorname.toString())

        }


        binding.btnupdate.setOnClickListener {
            val newBooktitleId = binding.updatebooktitleid.text.toString().toInt()
            val newBookName = binding.updatebookname.text.toString()
            val newBookDescription = binding.updatebookdescription.text.toString()
            val newauthorname = binding.updateauthorname.text.toString()


            var updateMap= mutableMapOf<String,Any>()

            updateMap["booktitleId"]=newBooktitleId
            updateMap["bookName"]=newBookName
            updateMap["bookdescription"]=newBookDescription
            updateMap["bookauthorname"]=newauthorname
            bookViewModel.updateBook(id,updateMap){
                    success,message->
                if(success){
                    Toast.makeText(this@UpdatebookadminActivity,
                        message, Toast.LENGTH_LONG).show()

                    finish()
                }else{
                    Toast.makeText(this@UpdatebookadminActivity,
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