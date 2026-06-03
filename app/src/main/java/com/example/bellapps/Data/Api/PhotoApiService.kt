package com.example.bellapps.Data.Api

import com.example.bellapps.Data.Model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list") //mengumpulkan/mengambl data dari server di route list
    suspend fun getPhotos(): List<PhotoModel>

//    @PUT("list") //mengupdate data di server

}