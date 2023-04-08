package com.example.movieapp.data.network.model

data class RatingDto(
    val await: Double,
    val filmCritics: Int,
    val imdb: Double,
    val kp: Double,
    val russianFilmCritics: Double,
    val tmdb: Double
)