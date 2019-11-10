package com.modos.persianflix

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PhotoModel(

    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("url")
    val url: String
)