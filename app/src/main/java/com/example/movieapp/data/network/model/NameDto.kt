package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("type")
    val type: String
)