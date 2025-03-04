package com.example.myapplicationlibrary

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationlibrary.adapter.UserBookAdapter

class ViewBookUser : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val bookname = ArrayList<String>()
    val bookdescription = ArrayList<String>()
    val authorname = ArrayList<String>()
    lateinit var adapter: UserBookAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_book_user)
        recyclerView = findViewById(R.id.recycleview0)

        bookname.add("To Kill a Mockingbird")
        bookname.add("Pride and Prejudice")
        bookname.add("The Silent Patient ")
        bookname.add("Sherlock Holmes")
        bookname.add("The little prince")


        bookdescription.add("A powerful story about racial injustice and morality seen through the eyes of a young girl in the American South.")
        bookdescription.add("A timeless romance about love, class, and societal expectations in 19th-century England.")
        bookdescription.add("A psychological thriller about a woman who stops speaking after allegedly murdering her husband.")
        bookdescription.add("A collection of detective stories following the brilliant investigator Sherlock Holmes")
        bookdescription.add("A whimsical yet profound story about love, loss, and seeing the world through a child’s eyes.")


        authorname.add("Harper Lee")
        authorname.add("Jane Austen")
        authorname.add(" Alex Michaelides")
        authorname.add("Arthur Conan Doyle")
        authorname.add("Antoine de Saint-Exupéry")




        adapter = UserBookAdapter(this@ViewBookUser, bookname, bookdescription,authorname)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@ViewBookUser,
            LinearLayoutManager.VERTICAL,false)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}