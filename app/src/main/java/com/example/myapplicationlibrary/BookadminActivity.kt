package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.c35c.model.BookModel
import com.example.c35c.repository.BookRepositoryImpl
import com.example.myapplicationlibrary.databinding.ActivityBookadminBinding
import com.example.myapplicationlibrary.viewmodel.BookViewModel
import com.google.firebase.database.FirebaseDatabase

class BookadminActivity : AppCompatActivity() {
    lateinit var binding: ActivityBookadminBinding
    lateinit var bookViewModel: BookViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBookadminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        var repo = BookRepositoryImpl(FirebaseDatabase.getInstance())
        bookViewModel = BookViewModel(repo)

        binding.btnaddbook.setOnClickListener {


            var bookkid = binding.editTitleid.text.toString().toInt()
            var bookkname = binding.editbooknamee.text.toString()
            var boookkdescriptionn = binding.editdescription.text.toString()
            var bookkauthornamee = binding.edutauthorname.text.toString()

            var model = BookModel("",bookkid, bookkname,boookkdescriptionn,bookkauthornamee)

            bookViewModel.addBook(model){

                    success,message->
                if(success){
                    Toast.makeText(this@BookadminActivity,
                        message, Toast.LENGTH_LONG).show()
                    val intent= Intent(
                        this@BookadminActivity,
                        OutputbookadminActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@BookadminActivity,
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