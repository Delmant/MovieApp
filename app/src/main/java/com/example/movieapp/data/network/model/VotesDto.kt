package com.example.movieapp.data.network.model

import com.google.gson.annotations.SerializedName

data class VotesDto(
    @SerializedName("kp")
    val kp: String,
    @SerializedName("imdb")
    val imdb: String,
    @SerializedName("tmdb")
    val tmdb: Int,
    @SerializedName("filmCritics")
    val filmCritics: Int,
    @SerializedName("russianFilmCritics")
    val russianFilmCritics: Int,
    @SerializedName("await")
    val await: Int
)