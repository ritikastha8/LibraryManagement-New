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
import com.example.myapplicationlibrary.R
import com.example.myapplicationlibrary.UpdatebookadminActivity

class BookAdapter(val context: Context,
                  var data:ArrayList<BookModel>
): RecyclerView.Adapter<BookAdapter.bookViewHolder>() {
    class bookViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView){
            val booktitleid: TextView = itemView.findViewById(R.id.booktitle)
        val bookName: TextView = itemView.findViewById(R.id.booknametext)
        val editBtn: TextView = itemView.findViewById(R.id.lblEditt)
        val bookdescription: TextView = itemView.findViewById(R.id.bookdescription)
        val authorname: TextView = itemView.findViewById(R.id.authorname)
        val loading : ProgressBar = itemView.findViewById(R.id.progressBarrr)
    }
//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookAdapter.bookViewHolder {
        val itemView: View = LayoutInflater.from(context)
            .inflate(R.layout.sample_book, parent, false)
        return bookViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BookAdapter.bookViewHolder, position: Int) {
        holder.booktitleid.text=data[position].booktitleId.toString()
        holder.bookName.text=data[position].bookName
        holder.bookdescription.text=data[position].bookdescription
        holder.authorname.text=data[position].bookauthorname
        holder.loading.visibility = View.GONE
        holder.editBtn.setOnClickListener{
            var intent = Intent(context,UpdatebookadminActivity::class.java)
            intent.putExtra("bookid",data[position].bookid)
            context.startActivity(intent)
        }
    }
    fun updateData(books:List<BookModel>){
        data.clear()
        data.addAll(books)
        notifyDataSetChanged()
    }
    //delete ko lagi
    fun getbookId(position: Int):String{
        return data[position].bookid

    }
}


//
//=======
//
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplicationlibrary.databinding.ItemBookBinding
//
//class BookAdapter(private val books: List<String>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
//
//    class BookViewHolder(private val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(bookTitle: String) {
//            binding.tvBookTitle.text = bookTitle
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
//        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return BookViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
//        holder.bind(books[position])
//    }
//
//    override fun getItemCount(): Int {
//        return books.size
//    }
//}
//>>>>>>> bef6f4bcac2bb07dc7f1b5e75cee375b0860f2f9
