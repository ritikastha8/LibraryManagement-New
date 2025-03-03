package com.example.c35c.repository
import com.example.c35c.model.BookModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
class BookRepositoryImpl (val database : FirebaseDatabase):BookRepository {
    //initialize table
    val ref:DatabaseReference = database.reference
        .child("books")
    override fun addBook(bookModel: BookModel, callback: (Boolean, String) -> Unit) {
        var id = ref.push().key.toString()
        bookModel.bookid=id
        ref.child(id).setValue(bookModel).addOnCompleteListener {
            if(it.isSuccessful){
                callback(true,"Book Added successfully")
            }else{
                callback(false,"${it.exception?.message}")
            }
        }
    }
    //
    override fun updateBook(
        bookid: String,
        data: MutableMap<String, Any>,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(bookid).updateChildren(data).addOnCompleteListener {
            if(it.isSuccessful){
                callback(true,"Book updated successfully")

            }else{
                callback(false,"${it.exception?.message}")
            }
        }
    }
    override fun deleteBook(
        bookid: String,
        callback: (Boolean, String) -> Unit) {
        ref.child(bookid).removeValue().addOnCompleteListener {
            if(it.isSuccessful){
                callback(true,"Book deleted successfully")
            }else{
                callback(false,"${it.exception?.message}")
            }
        }
    }
    override fun getBookById(
        bookid: String,
        callback: (BookModel?, Boolean, String) -> Unit
    ) {
        ref.child(bookid).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    var model = snapshot.getValue(BookModel::class.java)
                    callback(model,true,"Book fetched successfully")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                callback(null,false,error.message)
            }
        })
    }
    override fun getAllBooks(callback: (List<BookModel>?, Boolean, String) -> Unit) {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var book = mutableListOf<BookModel>()
                    for (eachData in snapshot.children) {
                        var model = eachData.getValue(BookModel::class.java)
                        if (model != null) {
                            book.add(model)
                        }
                    }
                    callback(book, true, "book fetched success")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                callback(null, false, error.message.toString())
            }
        })
    }
}


