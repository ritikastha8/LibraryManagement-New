package com.example.myapplicationlibrary.viewmodel
import android.content.Context
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import com.example.c35c.model.RequestModel
import com.example.c35c.repository.RequestRepository
class RequestViewModel (val repo : RequestRepository){
    fun addRequest(requestModel: RequestModel,
                callback:(Boolean,String)->Unit){
        repo.addRequest(requestModel ,callback)
    }
    fun updateRequest(requestidd:String,data:MutableMap<String,Any>,
                   callback:(Boolean,String)->Unit){
        repo.updateRequest(requestidd,data, callback)
    }
    fun deleteRequest(requestidd: String,
                   callback:(Boolean,String)->Unit){
        repo.deleteRequest(requestidd, callback)
    }
    var _requests = MutableLiveData<RequestModel?>()
    var requests = MutableLiveData<RequestModel?>()
        get () = _requests
    //
    var _allrequests= MutableLiveData<List<RequestModel>>()
    var allrequests = MutableLiveData<List<RequestModel>>()
        get () = _allrequests
    fun getRequestById(requestidd: String){
        repo.getRequestById(requestidd){
                model,success,message ->
            if (success){
                _requests.value = model
            }
        }
    }
    var _loading = MutableLiveData<Boolean>()
    var loading= MutableLiveData<Boolean>()
        get()=_loading
    fun getAllRequests(){
        _loading.value = true
        repo.getAllRequests { request,success,message->
            if (success){
                _allrequests.value = request
                _loading.value = false
            }
        }
    }
}