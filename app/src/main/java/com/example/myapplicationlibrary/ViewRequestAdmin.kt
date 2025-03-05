package com.example.myapplicationlibrary

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationlibrary.adapter.AdminRequestAdapter
import com.example.myapplicationlibrary.adapter.UserBookAdapter

class ViewRequestAdmin : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val request = ArrayList<String>()

    lateinit var adapter: AdminRequestAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_request_admin)
        recyclerView = findViewById(R.id.recyclevieww0)

        request.add("Request :\n I hope you are doing well. I would like to suggest adding 'Atomic Habits' by James Clear to our library collection. This book provides practical strategies for building good habits, breaking bad ones, making small changes that lead to remarkable results. It has been widely praised for its clear, actionable insights, would be a valuable resource for students and readers interested in self-improvement and productivity.")
        request.add("Request :\nI hope you are doing well. I would like to request the addition of 'The Psychology of Money' by Morgan Housel to our library collection. This book offers valuable insights into financial behavior and decision-making, making it a great resource for students and readers interested in personal finance and psychology.")
        request.add("Request :\n I would like to suggest adding \"The Alchemist\" by Paulo Coelho to our library collection. This book is an inspiring tale about following one's dreams and discovering one's true purpose in life. With its profound lessons on perseverance, destiny, and self-discovery, it has touched millions of readers worldwide. ")

        adapter = AdminRequestAdapter(this@ViewRequestAdmin, request)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@ViewRequestAdmin,
            LinearLayoutManager.VERTICAL,false)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}