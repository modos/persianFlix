package com.modos.persianflix

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataModel (

    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("photo")
    val photo: String,
    @Expose
    @SerializedName("bio")
    val bio: String
)