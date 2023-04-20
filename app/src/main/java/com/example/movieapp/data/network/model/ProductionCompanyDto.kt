package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class ProductionCompanyDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("previewUrl")
    val previewUrl: String
)