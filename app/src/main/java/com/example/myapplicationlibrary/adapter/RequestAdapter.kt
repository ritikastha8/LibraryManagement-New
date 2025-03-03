package com.example.myapplicationlibrary.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.c35c.model.BookModel
import com.example.c35c.model.RequestModel
import com.example.myapplicationlibrary.R
import com.example.myapplicationlibrary.UpdateRequestActivity
import com.example.myapplicationlibrary.UpdatebookadminActivity

class RequestAdapter(val context: Context,
                  var data:ArrayList<RequestModel>
): RecyclerView.Adapter<RequestAdapter.requestViewHolder>() {
    class requestViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){

        val requestdescription: TextView = itemView.findViewById(R.id.requestdescriptiontext)
        val editBtnn: TextView = itemView.findViewById(R.id.lbllEditt)
        val loading : ProgressBar = itemView.findViewById(R.id.progressBarr2)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestAdapter.requestViewHolder {
        val itemView: View = LayoutInflater.from(context)
            .inflate(R.layout.sample_request, parent, false)
        return requestViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: requestViewHolder, position: Int) {
        holder.requestdescription.text=data[position].requestdescription
        holder.loading.visibility = View.GONE
        holder.editBtnn.setOnClickListener{
            var intent = Intent(context,UpdateRequestActivity::class.java)
            intent.putExtra("requestidd",data[position].requestidd)
            context.startActivity(intent)
        }
    }
    fun updateData(requests:List<RequestModel>){
        data.clear()
        data.addAll(requests)
        notifyDataSetChanged()
    }
    //delete ko lagi
    fun getrequestId(position: Int):String{
        return data[position].requestidd
    }
}


