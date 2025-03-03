package com.example.c35c.repository
import com.example.c35c.model.RequestModel
interface RequestRepository {
    fun addRequest(requestModel: RequestModel,
                callback:(Boolean,String)->Unit)
    fun updateRequest(requestidd:String,data:MutableMap<String,Any>,
                   callback:(Boolean,String)->Unit)
    fun deleteRequest(requestidd: String,
                   callback:(Boolean,String)->Unit)
    fun getRequestById(requestidd: String,
                    callback:(RequestModel?,Boolean,String)->Unit)
    fun getAllRequests(callback:(List<RequestModel>?,Boolean,String)->Unit)
}







