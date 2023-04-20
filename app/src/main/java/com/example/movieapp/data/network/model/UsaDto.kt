package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class UsaDto(
    @SerializedName("value")
    val value: Int,
    @SerializedName("currency")
    val currency: String
)