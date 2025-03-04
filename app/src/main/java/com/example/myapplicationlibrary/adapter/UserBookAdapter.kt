package com.example.myapplicationlibrary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationlibrary.R

class UserBookAdapter(
    val context: Context,
    val bookname: ArrayList<String>,
    val bookdescription: ArrayList<String>,
    val authorname: ArrayList<String>,
) : RecyclerView.Adapter<UserBookAdapter.UserBooksViewHolder>(){
    class UserBooksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.booknaametext)
        val desc : TextView = itemView.findViewById(R.id.bookdescriptiontext)
        val author : TextView = itemView.findViewById(R.id.authornametext)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserBooksViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.sample_userviewbook,parent,false)
        return UserBooksViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: UserBooksViewHolder, position: Int) {
        holder.title.text = bookname[position]
        holder.desc.text = bookdescription[position]
        holder.author.text = authorname[position]

    }
}