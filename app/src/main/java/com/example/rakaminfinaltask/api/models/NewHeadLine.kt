package com.example.rakaminfinaltask.api.models

import android.os.Parcel
import android.os.Parcelable

data class NewHeadLine(
    var source: Source?,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Source::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(source, flags)
        parcel.writeString(author)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(url)
        parcel.writeString(urlToImage)
        parcel.writeString(publishedAt)
        parcel.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewHeadLine> {
        override fun createFromParcel(parcel: Parcel): NewHeadLine {
            return NewHeadLine(parcel)
        }

        override fun newArray(size: Int): Array<NewHeadLine?> {
            return arrayOfNulls(size)
        }
    }
}
