package com.modos.persianflix

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("file.php")
    fun getFile(): Call<List<DataModel>>

    @GET("photo.php")
    fun getPhoto(): Call<List<PhotoModel>>
}