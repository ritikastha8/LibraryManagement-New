package com.example.c35c.repository
import com.example.c35c.model.RequestModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
class RequestRepositoryImpl(val database : FirebaseDatabase):RequestRepository {
    //initialize database
//    val database:FirebaseDatabase=FirebaseDatabase.getInstance()
    //initialize table
    val ref:DatabaseReference = database.reference
        .child("requests")
    override fun addRequest(requestModel: RequestModel, callback: (Boolean, String) -> Unit) {
        var id = ref.push().key.toString()
        requestModel.requestidd=id
        ref.child(id).setValue(requestModel).addOnCompleteListener {
            if(it.isSuccessful){
                callback(true,"Request Added successfully")
            }else{
                callback(false,"${it.exception?.message}")
            }
        }
    }
    override fun updateRequest(
        requestidd: String,
        data: MutableMap<String, Any>,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(requestidd).updateChildren(data).addOnCompleteListener {
            if(it.isSuccessful){
                callback(true,"Request updated successfully")
            }else{
                callback(false,"${it.exception?.message}")
            }
        }
    }
    override fun deleteRequest(
        requestidd: String,
        callback: (Boolean, String) -> Unit) {
        ref.child(requestidd).removeValue().addOnCompleteListener {
            if(it.isSuccessful){
                callback(true,"Request deleted successfully")
            }else{
                callback(false,"${it.exception?.message}")
            }
        }
    }
    override fun getRequestById(
        requestidd: String,
        callback: (RequestModel?, Boolean, String) -> Unit
    ) {
        ref.child(requestidd).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    var model = snapshot.getValue(RequestModel::class.java)
                    callback(model,true,"Request fetched successfully")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                callback(null,false,error.message)
            }
        })
    }
    override fun getAllRequests(callback: (List<RequestModel>?, Boolean, String) -> Unit) {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    var request = mutableListOf<RequestModel>()
                    for (eachData in snapshot.children) {
                        var model = eachData.getValue(RequestModel::class.java)
                        if (model != null) {
                            request.add(model)
                        }
                    }
                    callback(request, true, "request fetched success")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                callback(null, false, error.message.toString())
            }
        })
    }
}



