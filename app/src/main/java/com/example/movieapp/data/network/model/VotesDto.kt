package com.example.movieapp.data.network.model

data class VotesDto(
    val await: Int,
    val filmCritics: Int,
    val imdb: String,
    val kp: String,
    val russianFilmCritics: Int,
    val tmdb: Int
)