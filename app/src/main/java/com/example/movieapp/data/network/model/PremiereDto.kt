package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class PremiereDto(
    @SerializedName("country")
    val country: String,
    @SerializedName("world")
    val world: String,
    @SerializedName("russia")
    val russia: String,
    @SerializedName("digital")
    val digital: String,
    @SerializedName("cinema")
    val cinema: String,
    @SerializedName("bluray")
    val bluray: String,
    @SerializedName("dvd")
    val dvd: String
)