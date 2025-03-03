package com.example.c35c.model
import android.os.Parcel
import android.os.Parcelable
//database sanga interact garna yeti vaye hunxa
data class RequestModel (
    var requestidd:String="",
    var requestdescription:String=""
)
    :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }
    //
    override fun writeToParcel(parcel: Parcel, flags: Int ) {
        parcel.writeString(requestidd)
        parcel.writeString(requestdescription)
    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<RequestModel> {
        override fun createFromParcel(parcel: Parcel): RequestModel {
            return RequestModel(parcel)
        }
        override fun newArray(size: Int): Array<RequestModel?> {
            return arrayOfNulls(size)
        }
    }
}

