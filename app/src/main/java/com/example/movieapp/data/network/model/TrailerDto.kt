package com.example.movieapp.data.network.model

import com.example.movieapp.domain.model.Trailers
import com.google.gson.annotations.SerializedName

data class TrailerDto(
    @SerializedName("trailers")
    val trailers: Trailers
)