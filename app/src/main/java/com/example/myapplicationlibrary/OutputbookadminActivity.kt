package com.example.myapplicationlibrary

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.c35c.repository.BookRepositoryImpl
import com.example.myapplicationlibrary.adapter.BookAdapter
import com.example.myapplicationlibrary.databinding.ActivityOutputbookadminBinding
import com.example.myapplicationlibrary.viewmodel.BookViewModel
import com.google.firebase.database.FirebaseDatabase
import java.util.ArrayList

class OutputbookadminActivity : AppCompatActivity() {
    lateinit var bookViewModel: BookViewModel
    lateinit var adapter: BookAdapter
    lateinit var binding:ActivityOutputbookadminBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOutputbookadminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var repo = BookRepositoryImpl(FirebaseDatabase.getInstance())
        bookViewModel=BookViewModel(repo)
//
        adapter = BookAdapter(this@OutputbookadminActivity, ArrayList())
        bookViewModel.getAllBooks()
        bookViewModel.allbooks.observe(this){books->
            books?.let{
                adapter.updateData(it)
            }
        }
        bookViewModel.loading.observe(this){loading->
            if(loading){
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE
            }
        }
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                var id = adapter.getbookId(viewHolder.adapterPosition)
                bookViewModel.deleteBook(id){
                        success,message->
                    if(success){
                        Toast.makeText(this@OutputbookadminActivity,
                            message, Toast.LENGTH_LONG).show()

                    }else{
                        Toast.makeText(this@OutputbookadminActivity,
                            message, Toast.LENGTH_LONG).show()
                    }
                }

            }

        }).attachToRecyclerView(binding.recyclerView)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}