package com.example.nestana.infamily.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by admin on 24.03.2018.
 */
class Document() : Parcelable{
    var title: String? = null
    var description: String? = null
    var schedule: String? = null
    var contacts: String? = null
    var address: String? = null

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        description = parcel.readString()
        schedule = parcel.readString()
        contacts = parcel.readString()
        address = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(schedule)
        parcel.writeString(contacts)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Document> {
        override fun createFromParcel(parcel: Parcel): Document {
            return Document(parcel)
        }

        override fun newArray(size: Int): Array<Document?> {
            return arrayOfNulls(size)
        }
    }

}