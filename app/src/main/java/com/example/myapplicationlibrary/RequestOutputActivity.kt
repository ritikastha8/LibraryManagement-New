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
import com.example.c35c.repository.RequestRepositoryImpl
import com.example.myapplicationlibrary.adapter.RequestAdapter
import com.example.myapplicationlibrary.databinding.ActivityRequestOutputBinding
import com.example.myapplicationlibrary.viewmodel.RequestViewModel
import com.google.firebase.database.FirebaseDatabase

//
class RequestOutputActivity : AppCompatActivity() {
    lateinit var requestViewModel: RequestViewModel
    lateinit var adapter: RequestAdapter
    lateinit var outputbinding:ActivityRequestOutputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       outputbinding= ActivityRequestOutputBinding.inflate(layoutInflater)
        setContentView(outputbinding.root)
        var repo = RequestRepositoryImpl(FirebaseDatabase.getInstance())
        requestViewModel= RequestViewModel(repo)
        adapter = RequestAdapter(this@RequestOutputActivity,ArrayList())
        requestViewModel.getAllRequests()
        requestViewModel.allrequests.observe(this){requests->
            requests?.let{
                adapter.updateData(it)
            }
        }
        requestViewModel.loading.observe(this){loading->
            if(loading){
                outputbinding.progressBar2.visibility = View.VISIBLE
            }else{
                outputbinding.progressBar2.visibility = View.GONE
            }
        }
        outputbinding.recyclerView2.adapter=adapter
        outputbinding.recyclerView2.layoutManager= LinearLayoutManager(this)
        ItemTouchHelper(object:
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var id = adapter.getrequestId(viewHolder.adapterPosition)
                requestViewModel.deleteRequest(id){
                        success,message->
                    if(success){
                        Toast.makeText(this@RequestOutputActivity,
                            message, Toast.LENGTH_LONG).show()

                    }else{
                        Toast.makeText(this@RequestOutputActivity,
                            message, Toast.LENGTH_LONG).show()
                    }
                }
            }

        }).attachToRecyclerView(outputbinding.recyclerView2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}


