package com.example.movieapp.data.remote_data_source

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://api.kinopoisk.dev/"

    private val retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    val apiService = retrofit.create(ApiService::class.java)
}