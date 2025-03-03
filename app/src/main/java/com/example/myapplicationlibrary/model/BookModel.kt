package com.example.c35c.model
import android.os.Parcel
import android.os.Parcelable
//database sanga interact garna yeti vaye hunxa
data class BookModel (
    var bookid:String="",
    var booktitleId:Int=0,
    var bookName:String="",
    var bookdescription:String="",
    var bookauthorname:String=""
   )
    :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readInt()?:0,
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readString()?:""
    ) {
    }
    override fun writeToParcel(parcel: Parcel, flags: Int ) {
        parcel.writeString(bookid)
        parcel.writeInt(booktitleId)
        parcel.writeString(bookName)
        parcel.writeString(bookdescription)
        parcel.writeString(bookauthorname)
    }
    override fun describeContents(): Int {
        return 0
    }
    //
    companion object CREATOR : Parcelable.Creator<BookModel> {
        override fun createFromParcel(parcel: Parcel): BookModel {
            return BookModel(parcel)
        }
        override fun newArray(size: Int): Array<BookModel?> {
            return arrayOfNulls(size)
        }
    }
}


