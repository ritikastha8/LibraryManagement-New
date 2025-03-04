package com.example.myapplicationlibrary.Model

import android.os.Parcel
import android.os.Parcelable
import com.example.c35c.model.RequestModel

data class UserModel(
    val username: String,
    val email: String,
    val password: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }
    //
    override fun writeToParcel(parcel: Parcel, flags: Int ) {
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(password)
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
