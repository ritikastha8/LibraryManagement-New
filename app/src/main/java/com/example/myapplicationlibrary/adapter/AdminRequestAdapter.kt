package com.example.myapplicationlibrary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationlibrary.R
import com.example.myapplicationlibrary.adapter.UserBookAdapter.UserBooksViewHolder

class AdminRequestAdapter(val context: Context,
                          val request: ArrayList<String>):

    RecyclerView.Adapter<AdminRequestAdapter.AdminRequestsViewHolder>() {

    class AdminRequestsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val enterrequest: TextView = itemView.findViewById(R.id.requesttextttt)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminRequestsViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.sample_adminviewrequest,parent,false)
        return AdminRequestsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: AdminRequestsViewHolder, position: Int) {
        holder.enterrequest.text = request[position]


    }

}