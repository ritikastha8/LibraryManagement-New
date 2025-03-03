package com.example.c35c.repository
import android.content.Context
import android.net.Uri
import com.example.c35c.model.BookModel
interface BookRepository {
    fun addBook(bookModel: BookModel,
                   callback:(Boolean,String)->Unit)
    fun updateBook(bookid:String,data:MutableMap<String,Any>,
                      callback:(Boolean,String)->Unit)
    fun deleteBook(bookid: String,
                      callback:(Boolean,String)->Unit)
    fun getBookById(bookid: String,
                       callback:(BookModel?,Boolean,String)->Unit)
    fun getAllBooks(callback:(List<BookModel>?,Boolean,String)->Unit)
    //
}

//