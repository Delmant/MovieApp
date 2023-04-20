package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("logo")
    val logoDto: LogoDto,
    @SerializedName("url")
    val url: String
)