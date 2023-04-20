package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class LogoDto(
    @SerializedName("url")
    val url: String
)