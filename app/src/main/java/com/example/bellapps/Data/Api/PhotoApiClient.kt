package com.example.bellapps.Data.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PhotoApiClient {
    private const val BASE_URL = "https://picsum.photos/v2/" //INDUKNYA AJA, KARENA ITU KITA MENGGUNKn get utk mengambil data dgn GET

    val apiService: PhotoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoApiService::class.java)
    }
}