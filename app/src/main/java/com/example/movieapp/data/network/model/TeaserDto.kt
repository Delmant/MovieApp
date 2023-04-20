package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class TeaserDto(
    @SerializedName("url")
    val url: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("site")
    val site: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("size")
    val size: Int
)