package com.example.myapplicationlibrary.viewmodel
import android.content.Context
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.example.c35c.model.BookModel
import com.example.c35c.repository.BookRepository
class BookViewModel (val repo : BookRepository){
    fun addBook(bookModel: BookModel,
                   callback:(Boolean,String)->Unit){
        repo.addBook  (bookModel ,callback)
    }
    fun updateBook(bookid:String,data:MutableMap<String,Any>,
                      callback:(Boolean,String)->Unit){
        repo.updateBook(bookid,data, callback)
    }
    fun deleteBook(bookid: String,
                      callback:(Boolean,String)->Unit){
        repo.deleteBook(bookid, callback)
    }
    var _books = MutableLiveData<BookModel?>()
    var books = MutableLiveData<BookModel?>()
        get () = _books
    var _allbooks = MutableLiveData<List<BookModel>>()
    var allbooks = MutableLiveData<List<BookModel>>()
        get () = _allbooks
    fun getBookById(bookid: String){
        repo.getBookById(bookid){
                model,success,message ->
            if (success){
                _books.value = model
            }
        }
    }
    var _loading = MutableLiveData<Boolean>()
    var loading= MutableLiveData<Boolean>()
        get()=_loading
    fun getAllBooks(){
        _loading.value = true
        repo.getAllBooks{book,success,message->
            if (success){
                _allbooks.value = book
                _loading.value = false
            }
        }
    }
}

