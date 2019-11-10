package com.modos.persianflix

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ParcelableObject( val name: String,
                             val photo: String,
                             val bio: String) : Parcelable