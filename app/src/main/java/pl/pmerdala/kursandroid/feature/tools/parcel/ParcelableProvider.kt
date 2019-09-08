package pl.pmerdala.kursandroid.feature.tools.parcel

import android.os.Parcelable

interface ParcelableProvider {
    fun from(from:Any):Parcelable
}