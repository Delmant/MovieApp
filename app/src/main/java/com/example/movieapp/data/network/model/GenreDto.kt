package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class GenreDto(
    @SerializedName("name")
    val name: String
)