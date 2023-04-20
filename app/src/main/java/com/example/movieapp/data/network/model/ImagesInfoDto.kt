package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ImagesInfoDto(
    @SerializedName("postersCount")
    val postersCount: Int,
    @SerializedName("backdropsCount")
    val backdropsCount: Int,
    @SerializedName("framesCount")
    val framesCount: Int
)